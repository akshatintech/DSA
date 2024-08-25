/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        HashMap<Node , Node> map =new HashMap<>();
        Node curr = head;
        Node prev =null;
        Node newHead = null;

        while(curr != null){
            Node temp = new Node(curr.val);
            map.put(curr , temp);

            if(newHead == null){
                newHead = temp;
                prev = newHead;
            }
            else{
                prev.next= temp;
                prev = temp;
            }
            curr = curr.next;
        }

        curr = head;
        Node newCurr = newHead;
        while(curr != null){
            if(curr.random == null){
                newCurr.random = null;
            }
            else{
                newCurr.random = map.get(curr.random);
            }

            newCurr = newCurr.next;
            curr = curr.next;
        }

        return newHead;
    }
}