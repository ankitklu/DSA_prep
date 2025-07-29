import java.util.*;

public class Amount_of_Time_for_Binary_Tree_to_Be_Infected {

}

/*
 * 2385. Amount of Time for Binary Tree to Be Infected
 * 
 * avatar
 * Discuss Approach
 * arrow-up
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * You are given the root of a binary tree with unique values, and an integer
 * start. At minute 0, an infection starts from the node with value start.
 * 
 * Each minute, a node becomes infected if:
 * 
 * The node is currently uninfected.
 * The node is adjacent to an infected node.
 * Return the number of minutes needed for the entire tree to be infected.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,5,3,null,4,10,6,9,2], start = 3
 * Output: 4
 * Explanation: The following nodes are infected during:
 * - Minute 0: Node 3
 * - Minute 1: Nodes 1, 10 and 6
 * - Minute 2: Node 5
 * - Minute 3: Node 4
 * - Minute 4: Nodes 9 and 2
 * It takes 4 minutes for the whole tree to be infected so we return 4.
 * Example 2:
 * 
 * 
 * Input: root = [1], start = 1
 * Output: 0
 * Explanation: At minute 0, the only node in the tree is infected so we return
 * 0.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 105].
 * 1 <= Node.val <= 105
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

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        TreeNode head = buildGraph(root, graph, start);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        visited.put(head, true);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                for (TreeNode neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.containsKey(neighbor)) {
                        visited.put(neighbor, true);
                        queue.add(neighbor);
                    }
                }
            }

            time++;
        }

        return time - 1;
    }

    private TreeNode buildGraph(TreeNode root, Map<TreeNode, List<TreeNode>> graph, int start) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode startNode = null;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.val == start) {
                startNode = curr;
            }

            if (curr.left != null) {
                queue.add(curr.left);

                if (!graph.containsKey(curr)) {
                    graph.put(curr, new ArrayList<>());
                }
                if (!graph.containsKey(curr.left)) {
                    graph.put(curr.left, new ArrayList<>());
                }
                graph.get(curr).add(curr.left);
                graph.get(curr.left).add(curr);
            }

            if (curr.right != null) {
                queue.add(curr.right);

                if (!graph.containsKey(curr)) {
                    graph.put(curr, new ArrayList<>());
                }
                if (!graph.containsKey(curr.right)) {
                    graph.put(curr.right, new ArrayList<>());
                }
                graph.get(curr).add(curr.right);
                graph.get(curr.right).add(curr);
            }
        }

        return startNode;
    }
}
