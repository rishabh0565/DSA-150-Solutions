package LinkedList;

import java.util.ArrayList;

//You are given an array of k linked lists lists, where each list is sorted in ascending order.
//
//Return the sorted linked list that is the result of merging all of the individual linked lists.
//
//Example 1:
//
//Input: lists = [[1,2,4],[1,3,5],[3,6]]
//
//Output: [1,1,2,3,3,4,5,6]
//Example 2:
//
//Input: lists = []
//
//Output: []
//Example 3:
//
//Input: lists = [[]]
//
//Output: []
public class MergeKSortedLinkedList {
	public ListNode mergeKLists(ListNode[] lists) {
	        if (lists.length == 0 || lists == null) 
	        	return null;
	   
 	       while (lists.length > 1) {
 	    	     ArrayList<ListNode> mergedLists = new ArrayList<>(); 
 	    	     for(int  i = 0 ; i < lists.length ; i+=2) {
 	    	    	  ListNode l1 = lists[i]; 
 	    	    	  ListNode l2 =  (i+1 >= lists.length )? null : lists[i+1]; 
 	    	    	  mergedLists.add( merge(l1, l2)); 
 	    	    	 
 	    	     }
 	    	     
 	    	    lists = mergedLists.toArray(new ListNode[0]);
 	       }
 	       return lists[0]; 
	}
	
	public ListNode merge(ListNode l1 , ListNode l2) {
		  ListNode dummy = new ListNode(0); 
	       ListNode current = dummy; 
	       while(l1!=null && l2!=null) { 
	           if(l1.val< l2.val){
	             current.next = l1;
	             l1 = l1.next;  
	           }
	           else{
	            current.next = l2;
	            l2 = l2.next;  
	           }
	           current = current.next; 
	       }
	       if(l1!=null){
	          current.next = l1; 
	       }
	       if(l2 != null){
	         current.next = l2; 
	       }
	      return dummy.next;
	}

}
