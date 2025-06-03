package LinkedList;
//You are given two non-empty linked lists, l1 and l2, where each represents a non-negative integer.

//
//The digits are stored in reverse order, e.g. the number 123 is represented as 3 -> 2 -> 1 -> in the linked list.
//
//Each of the nodes contains a single digit. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Return the sum of the two numbers as a linked list.
//
//Example 1:
//
//
//
//Input: l1 = [1,2,3], l2 = [4,5,6]
//
//Output: [5,7,9]
//
//Explanation: 321 + 654 = 975.
//Example 2:
//
//Input: l1 = [9], l2 = [9]
//
//Output: [8,1]

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode current = dummy;
	      int carry = 0;
		while (l1 != null || l2 != null || carry > 0) {
			int val1 = 0;
			int val2 = 0;
			if (l1 != null) {
				val1 = l1.val;
			}
			if (l2 != null) {
				val2 = l2.val;
			}
			 int res = (val1 + val2 + carry) % 10;
			if ((val1 + val2 + carry) >= 10) carry = 1; 
			else carry=0;
			current.next = new ListNode(res);
			current = current.next;
		if(l1!=null)	l1 = l1.next;
		if(l2!=null)	l2 = l2.next;
		}

		return dummy.next;
	}
}
