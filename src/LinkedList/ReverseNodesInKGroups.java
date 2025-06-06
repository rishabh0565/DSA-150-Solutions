package LinkedList;
//You are given the head of a singly linked list head and a positive integer k.
//
//You must reverse the first k nodes in the linked list, and then reverse the next k nodes, and so on. If there are fewer than k nodes left, leave the nodes as they are.
//
//Return the modified list after reversing the nodes in each group of k.
//
//You are only allowed to modify the nodes' next pointers, not the values of the nodes.
//Input: head = [1,2,3,4,5,6], k = 3
//
//Output: [3,2,1,6,5,4]
//Example 2:
//
//
//
//Input: head = [1,2,3,4,5], k = 3
//
//Output: [3,2,1,4,5]
//Constraints:
//
//The length of the linked list is n.
//1 <= k <= n <= 100
//0 <= Node.val <= 100
public class ReverseNodesInKGroups {

    public ListNode reverseKGroup(ListNode head, int k) {
        // finding length of the linked list. 
        int length = 0;
        ListNode curr = head;  
        while(curr!=null){
             length++; 
             curr = curr.next; 
        }
        int group = length/k; 
        ListNode dummy = new ListNode(0); 
        
        // node just before group start 
        ListNode groupPrev = dummy; 
        // group first node 
        ListNode current = head; 
        while (group-- >0){
              ListNode groupTail = current;
              ListNode prev = null; 
              for(int i = 0 ; i < k ; i++){
                  ListNode temp = current.next ;
                  current.next = prev; 
                  prev = current; 
                  current = temp; 
              } 
              groupPrev.next = prev ;
              groupPrev = groupTail ;  
        }
        groupPrev.next = current; 
        return dummy.next; 
    }

}
