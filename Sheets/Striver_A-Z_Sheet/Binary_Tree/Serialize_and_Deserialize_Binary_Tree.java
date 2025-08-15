import java.util.*;

/*
 * 297. Serialize and Deserialize Binary Tree
Solved

avatar
Discuss Approach
arrow-up
Hard
Topics
premium lock icon
Companies
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
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
public class Serialize_and_Deserialize_Binary_Tree {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "null";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder("");

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            
            if(curr==null){
                sb.append("null,");
                continue;
            }

            sb.append(curr.val).append(",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")){
            return null;
        }
        Queue<TreeNode> q= new LinkedList<>();
        String arr[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        int i=1;
        q.add(root);

        while(!q.isEmpty() && i<arr.length){
            TreeNode curr = q.poll();
            
            if(i<data.length() && !arr[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            i++;
            if(i<data.length() && !arr[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
