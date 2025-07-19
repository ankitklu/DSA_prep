import java.util.*;
public class Reverse_Nodes_in_k_Group {
    
}
/*
 * 25. Reverse Nodes in k-Group
Solved

avatar
Discuss Approach
arrow-up
Hard
Topics
premium lock icon
Companies
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy= new ListNode(-1);
        dummy.next=head;
        ListNode newHead=dummy;
        ListNode temp= head;

        // -1 -> 2 -> 

        Stack<Integer> s= new Stack<>(); //2 , 1
        while(temp!=null){
            int count=0;
            while(temp!=null && count<k){
                s.push(temp.val);
                temp= temp.next;
                count++;
            }

            if(count <k){
                Stack<Integer> nStack= new Stack<>();
                while(!s.isEmpty()){
                    nStack.add(s.pop());
                }
                while(!nStack.isEmpty() && count>0){
                    newHead.next= new ListNode(nStack.pop());
                    newHead=newHead.next;
                    count--;
                }
            }

            while(!s.isEmpty()){
                newHead.next= new ListNode(s.pop());
                newHead=newHead.next;
            }
            // temp=temp.next;

        }
        
        return dummy.next;
    }
}
