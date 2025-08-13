public class Kth_Smallest_Element_in_a_BST {

}
/*
 * 230. Kth Smallest Element in a BST
 * Solved
 * 
 * avatar
 * Discuss Approach
 * arrow-up
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given the root of a binary search tree, and an integer k, return the kth
 * smallest value (1-indexed) of all the values of the nodes in the tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * 
 * 
 * Follow up: If the BST is modified often (i.e., we can do insert and delete
 * operations) and you need to find the kth smallest frequently, how would you
 * optimize?
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int count = 0;
    int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    public void helper(TreeNode root, int k) {
        if (root == null || count >= k) {
            return;
        }
        helper(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        helper(root.right, k);
    }
}