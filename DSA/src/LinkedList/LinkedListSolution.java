package LinkedList;

public class LinkedListSolution {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val , ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode leftPointer = head;

        ListNode curr = head.next;
        int sum = 0;
        while(curr != null){

            while(curr.val != 0){

                sum = curr.val + sum;
                curr = curr.next;

            }
            leftPointer.next = new ListNode(sum);
            leftPointer =leftPointer.next;
            sum = 0;
            curr = curr.next;
        }
        leftPointer.next = null;
        return head.next;
    }
}
