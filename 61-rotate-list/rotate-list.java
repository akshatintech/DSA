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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head;
        }
        ListNode curr = head;
        int length = 1;
        while(curr.next != null){
            curr = curr.next;
            length ++;
        }
        curr.next = head;       //Making the list circular
        k = k %length;
        int stepsToNewHead = length-k;

        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        ListNode newNode =newTail.next;
        newTail.next = null;
        return newNode;
    }
}