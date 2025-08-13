/*
 * 99. Recover Binary Search Tree

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 

Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
 

Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        store(root, l);
        Collections.sort(l);
        create(root ,l);
    }
    public void store(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        store(root.left, list);
        list.add(root.val);
        store(root.right, list);
    }
    public void create(TreeNode root, List<Integer> l){
        if(root==null){
            return;
        }
        create(root.left, l);
        root.val = l.get(0);
        l.remove(0);
        create(root.right, l);
    }

}