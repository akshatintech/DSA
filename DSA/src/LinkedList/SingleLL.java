package LinkedList;

import java.util.LinkedList;

class Node{
	 
	 int val;
	 Node next;
	 Node(int val , Node next){
		 this.val= val;
		 this.next = next;
	 }
	
}
public class SingleLL {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		ll.add(1);
		ll.add(3);
		ll.add(4);
		ll.add(7);
		ll.add(1);
		ll.add(2);
		ll.add(6);
		
		
	}
	
	 public static Node deleteMiddle(Node head) {
	        
	        Node temp = head;
	        int count = 1;
	        while(temp != null){
	            temp = temp.next;
	            count++;
	        }

	        if(head == null){
	            return null;
	        }
	        if(count == 3){
	            return head;
	        }

	        int mid = 0;
	        if(count %2 == 0){
	            mid = count/2;
	        }

	        else{
	            mid = count/2;
	            mid = mid+1;
	        }

	        count  = 0;
	        
	        Node prev = head;
	        Node todel = prev.next;
	        
	        while(count == (mid-2)){
	            prev = prev.next;
	            todel = prev.next;
	                     
	        }

	        prev.next = todel.next;
	        todel = null;
	        return head;
	        
	        
	    }
}
