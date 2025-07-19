import java.util.*;
public class Linked_List_Random_Node {
    
}
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
    List<Integer> ans = new ArrayList<>();
    public Solution(ListNode head) {
        while(head!=null){
            ans.add(head.val);
            head=head.next;
        }
    }
    
    public int getRandom() {
        double index = Math.random()*ans.size();
        return ans.get((int)index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
