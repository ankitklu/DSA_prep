public class Construct_Binary_Search_Tree_from_Preorder_Traversal {

}

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

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int ele : preorder) {
            root = insert(root, ele);
        }
        return root;
    }

    public TreeNode insert(TreeNode root, int ele) {
        if (root == null) {
            return new TreeNode(ele);
        }
        if (ele > root.val) {
            root.right = insert(root.right, ele);
        } else {
            root.left = insert(root.left, ele);
        }
        return root;
    }
}
