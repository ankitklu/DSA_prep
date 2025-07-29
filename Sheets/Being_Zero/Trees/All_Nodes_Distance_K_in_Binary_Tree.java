import java.util.*;
public class All_Nodes_Distance_K_in_Binary_Tree {
    
}
/*
 * 863. All Nodes Distance K in Binary Tree

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    static class Pair{
        TreeNode node;
        int dist;
        public Pair(TreeNode node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> graph= new HashMap<>();
        store(root, graph);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<Pair> q= new LinkedList<>();

        vis.put(target, true);
        q.add(new Pair(target,0));
        List<Integer> ans= new ArrayList<>();

        while(!q.isEmpty()){
            Pair curr= q.poll();
            int dist= curr.dist;
            if(dist==k){
                ans.add(curr.node.val);
            }
            for(TreeNode neigh : graph.getOrDefault(curr.node, new ArrayList<>())){
                if(!vis.containsKey(neigh)){
                    vis.put(neigh,true);
                    q.add(new Pair(neigh,dist+1));
                }
            }
        }
        return ans;
    }
    public void store(TreeNode root, Map<TreeNode, List<TreeNode>> graph){
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr= q.poll();
            if(curr.left!=null){
                q.add(curr.left);
                if(!graph.containsKey(curr)){
                    graph.put(curr, new ArrayList<>());
                }
                if(!graph.containsKey(curr.left)){
                    graph.put(curr.left, new ArrayList<>());
                }
                graph.get(curr).add(curr.left);
                graph.get(curr.left).add(curr);
            }
            if(curr.right!=null){
                q.add(curr.right);
                if(!graph.containsKey(curr)){
                    graph.put(curr, new ArrayList<>());
                }
                if(!graph.containsKey(curr.right)){
                    graph.put(curr.right, new ArrayList<>());
                }
                graph.get(curr).add(curr.right);
                graph.get(curr.right).add(curr);
            }
        }
    }
}
