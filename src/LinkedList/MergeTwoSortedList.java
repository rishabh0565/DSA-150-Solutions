package LinkedList;
//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
//
//The new list should be made up of nodes from list1 and list2.
//
//Input: list1 = [1,2,4], list2 = [1,3,5]
//
//Output: [1,1,2,3,4,5]
//Example 2:
//
//Input: list1 = [], list2 = [1,2]
//
//Output: [1,2]
//Example 3:
//
//Input: list1 = [], list2 = []
//
//Output: []
public class MergeTwoSortedList {
	 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        ListNode dummy = new ListNode(); 
	        ListNode curr  = dummy; 
	        while(list1!=null && list2!=null){
	             if(list1.val < list2.val){
	                   curr.next = list1; 
	                   list1 = list1.next; 
	             }
	             else{
	                curr.next = list2;     
	                list2 = list2.next;   
	             }
	             curr = curr.next; 
	        }
	        if(list1!=null){
	             curr.next = list1; 
	        }
	        else {
	            curr.next = list2;
	        }
	        return dummy.next;
	    }
}
