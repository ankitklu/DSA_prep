package Sheets.Being_Zero.Trees;

import java.util.*;

public class Maximum_Width_of_Binary_Tree {

}
/*
 * 662. Maximum Width of Binary Tree
 * 
 * avatar
 * Discuss Approach
 * arrow-up
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given the root of a binary tree, return the maximum width of the given tree.
 * 
 * The maximum width of a tree is the maximum width among all levels.
 * 
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and rightmost non-null nodes), where the null nodes between the
 * end-nodes that would be present in a complete binary tree extending down to
 * that level are also counted into the length calculation.
 * 
 * It is guaranteed that the answer will in the range of a 32-bit signed
 * integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width exists in the third level with length 4
 * (5,3,null,9).
 * Example 2:
 * 
 * 
 * Input: root = [1,3,2,5,null,null,9,6,null,7]
 * Output: 7
 * Explanation: The maximum width exists in the fourth level with length 7
 * (6,null,null,null,null,null,7).
 * Example 3:
 * 
 * 
 * Input: root = [1,3,2,5]
 * Output: 2
 * Explanation: The maximum width exists in the second level with length 2
 * (3,2).
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 3000].
 * -100 <= Node.val <= 100
 * 
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
    static class TreeNode {
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

    static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new ArrayDeque<>();
        int max = 0;
        q.addLast(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int startIdx = q.peekFirst().index;
            int endIdx = q.peekLast().index;
            max = Math.max(max, endIdx - startIdx + 1);
            for (int i = 0; i < size; i++) {
                Pair top = q.poll();
                TreeNode curr = top.node;

                if (curr.left != null) {
                    q.addLast(new Pair(curr.left, 2 * top.index + 1));
                }
                if (curr.right != null) {
                    q.addLast(new Pair(curr.right, 2 * top.index + 2));
                }
            }
        }
        return max;
    }
}
