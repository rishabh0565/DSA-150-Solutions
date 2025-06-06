package LinkedList;


public class Main {
  public static void main(String[] args) {
	 ReverseNodesInKGroups rnikg =  new ReverseNodesInKGroups(); 
	 ListNode head1 = createLinkedList(new int[] {1,2,3,4,5,67});
     ListNode listNode =  rnikg.reverseKGroup(head1, 4); 
     display(listNode);
	   
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
	    	 System.out.print(curr.val + " -> ");
	    	 curr = curr.next; 
	    }
	    System.out.print("END");
 }
}




////////////////////////////////////////////  
//  used for question 
 class Nodee {
    int val;
    Nodee next;
    Nodee random;

    public Nodee(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public static Nodee createLinkedList(int [] arr) {
    	Nodee dummy  = new Nodee(0); 
    	Nodee current  = dummy; 
    	  for(int a : arr) {
    		  current.next = new Nodee(a); 
    		  current = current.next; 
    	  }
    	  return dummy.next; 
    }
    
    public static void display(Nodee head) {
  	  System.out.println();
  	Nodee curr = head ; 
  	    while(curr!=null) {
  	    	 System.out.print("Node : "+   curr.val + " Next -> "  +  ((curr.next == null) ? "null" : curr.next.val) + "-> Random -> " + ((curr.random == null) ? "null" : curr.random.val) );
  	    	 System.out.println();
  	    	 curr = curr.next; 
  	    }
   }
}
 
 ///   copy linked list with random pointer
 class NodeList {
 int val;
 NodeList next;
 NodeList() {}
 NodeList(int val) { this.val = val; }
 NodeList(int val, NodeList next) { this.val = val; this.next = next; }		      
}


