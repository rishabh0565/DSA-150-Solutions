package LinkedList;


public class Main {
  public static void main(String[] args) {
	  FindTheDuplicateNumber ftdn = new FindTheDuplicateNumber(); 
	 System.out.println( ftdn.findDuplicate(new int[] {1,9,2,3,4,5,6,7,8,2}));
	   
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
////////////////////////////////////////////  
//  used for question 
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public static Node createLinkedList(int [] arr) {
    	Node dummy  = new Node(0); 
    	Node current  = dummy; 
    	  for(int a : arr) {
    		  current.next = new Node(a); 
    		  current = current.next; 
    	  }
    	  return dummy.next; 
    }
    
    public static void display(Node head) {
  	  System.out.println();
  	Node curr = head ; 
  	    while(curr!=null) {
  	    	 System.out.print("Node : "+   curr.val + " Next -> "  +  ((curr.next == null) ? "null" : curr.next.val) + "-> Random -> " + ((curr.random == null) ? "null" : curr.random.val) );
  	    	 System.out.println();
  	    	 curr = curr.next; 
  	    }
   }
}


