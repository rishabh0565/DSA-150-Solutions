package LinkedList;


public class Main {
  public static void main(String[] args) {
	   RemoveNodeFromEndOfLinkedList rnfroll = new RemoveNodeFromEndOfLinkedList(); 
	   ListNode head  = createLinkedList(new int[] {5}); 
	  display( rnfroll.removeNthFromEnd(head , 1));
   }
  
  
  public static ListNode createLinkedList(int [] arr) {
	  ListNode dummy  = new ListNode(); 
	  ListNode current  = dummy; 
	  for(int a : arr) {
		  current.next = new ListNode(a); 
		  current = current.next; 
	  }
	  return dummy.next; 
  }
  
  public static void display(ListNode head) {
	  System.out.println();
	    ListNode curr = head ; 
	    while(curr!=null) {
	    	 System.out.print(curr.val + " ");
	    	 curr = curr.next; 
	    }
 }
}
