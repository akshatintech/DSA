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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode  = new ListNode(-1);
        ListNode temp =  dummyNode;


        //traverse both the lists simultaneouslt
        while(list1 != null && list2 != null){
            //we will compare the elements of both the list and change the nodes
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }

            //move the temp pointer
            temp = temp.next;
        }
            //If there is any difference in the size we will just add them
            if(list1 != null){
                temp.next= list1;
            }
            if(list2 != null){
                temp.next= list2;
            }
        

        return dummyNode.next;
    }
}