package LinkedList;
//You are given the beginning of a linked list head, and an integer n.
//
//Remove the nth node from the end of the list and return the beginning of the list.
//
//Example 1:
//
//Input: head = [1,2,3,4], n = 2
//
//Output: [1,2,4]
//Example 2:
//
//Input: head = [5], n = 1
//
//Output: []
public class RemoveNodeFromEndOfLinkedList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(); 
        dummy.next = head; 
        ListNode slow = dummy; 
        ListNode fast = dummy;
        int i= 0 ; 
        while (i <= n) {
        	fast = fast.next; 
        	i++; 
        }
        
        while(fast!=null) {
        	 fast = fast.next; 
        	 slow = slow.next; 
        }
        
         slow.next = slow.next.next; 	
		
		return head; 

   }
}
