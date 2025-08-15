import java.util.*;

public class All_Nodes_Distance_K_in_Binary_Tree {

}
/*
 * 863. All Nodes Distance K in Binary Tree
 * Solved
 * 
 * avatar
 * Discuss Approach
 * arrow-up
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given the root of a binary tree, the value of a target node target, and an
 * integer k, return an array of the values of all nodes that have a distance k
 * from the target node.
 * 
 * You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value
 * 5) have values 7, 4, and 1.
 * Example 2:
 * 
 * Input: root = [1], target = 1, k = 3
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 */

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Pair {
        TreeNode node;
        int dist;

        public Pair(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        store(graph, root);

        Set<TreeNode> vis = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(target, 0));
        vis.add(target);

        List<Integer> l = new ArrayList<>();

        while (!q.isEmpty()) {
            Pair top = q.poll();
            TreeNode curr = top.node;
            int dist = top.dist;

            if (dist == k) {
                l.add(curr.val);
            }

            for (TreeNode neigh : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!vis.contains(neigh)) {
                    vis.add(neigh);
                    q.add(new Pair(neigh, dist + 1));
                }
            }
        }
        return l;
    }

    public void store(Map<TreeNode, List<TreeNode>> graph, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                graph.computeIfAbsent(curr, k -> new ArrayList<>()).add(curr.left);
                graph.computeIfAbsent(curr.left, k -> new ArrayList<>()).add(curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                graph.computeIfAbsent(curr, k -> new ArrayList<>()).add(curr.right);
                graph.computeIfAbsent(curr.right, k -> new ArrayList<>()).add(curr);
                q.add(curr.right);
            }
        }
    }
}
