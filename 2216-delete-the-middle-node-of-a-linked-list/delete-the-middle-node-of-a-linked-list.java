class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // return null if list has only one node or is empty
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Use slow and fast pointers to reach the middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }
}
