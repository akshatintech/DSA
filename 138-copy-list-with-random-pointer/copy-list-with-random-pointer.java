

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;

        while (curr != null) {
            Node currNext = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = currNext;
            curr = currNext;
        }

        // Deep copy of random pointers
        curr = head;
        while (curr != null && curr.next != null) {
            if (curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Deep copy of next pointers and recovering old linked list
        Node newHead = head.next;
        Node newCurr = newHead;
        curr = head;

        while (curr != null && newCurr != null) {
            if (curr.next != null) {
                curr.next = curr.next.next;
            } else {
                curr.next = null;
            }

            if (newCurr.next != null) {
                newCurr.next = newCurr.next.next;
            } else {
                newCurr.next = null;
            }

            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}