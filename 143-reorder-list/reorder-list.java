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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast= head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        

        ListNode prev = null;
        ListNode curr = slow;
        ListNode next= null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        ListNode first= head;
        ListNode second = prev;
        while(second.next != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next= second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
        

        
      
        
    }
}