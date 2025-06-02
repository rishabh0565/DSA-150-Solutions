package LinkedList;
//Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
//
//Example 1:
//
//Input: head = [0,1,2,3]
//
//Output: [3,2,1,0]
//Example 2:
//
//Input: head = []
//
//Output: []
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		 ListNode prev = null ; 
		 ListNode curr  = head; 
		 while(curr!=null) {
			  ListNode temp = curr.next; 
			  curr.next = prev; 
			  prev = curr; 
			  curr = temp ; 
		 }
		 return prev; 
	}
}
