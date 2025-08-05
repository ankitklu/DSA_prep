package Sheets.Being_Zero.LinkedList;

public class Swap_Nodes_in_Pairs {

}
/*
 * 24. Swap Nodes in Pairs
 * Solved
 * 
 * avatar
 * Discuss Approach
 * arrow-up
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given a linked list, swap every two adjacent nodes and return its head. You
 * must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4]
 * 
 * Output: [2,1,4,3]
 * 
 * Explanation:
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: head = []
 * 
 * Output: []
 * 
 * Example 3:
 * 
 * Input: head = [1]
 * 
 * Output: [1]
 * 
 * Example 4:
 * 
 * Input: head = [1,2,3]
 * 
 * Output: [2,1,3]
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode last = head;
        for (int i = 0; i < 2; i++) {
            if (last == null) {
                return head;
            }
            last = last.next;
        }
        ListNode newNode = reverse(head, last);
        head.next = swapPairs(last);
        return newNode;
    }

    public ListNode reverse(ListNode curr, ListNode last) {
        ListNode prev = null;
        while (curr != last) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
