package LinkedList;

//public class ListNode {
//		      int val;
//		      ListNode next;
//		      ListNode() {}
//		      ListNode(int val) { this.val = val; }
//		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }		      
//}

public class ListNode{
	     int val ; 
	     int key ; 
	     ListNode next ; 
	     ListNode prev; 

	     public ListNode(){
	         
	     }
	     public ListNode(int val){
	         this.val = val ; 
	     } 
	     public ListNode(int key, int val){
	         this.key = key ; 
	         this.val = val; 
	     }
}
