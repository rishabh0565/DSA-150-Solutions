package LinkedList;

import java.util.HashMap;
import java.util.Map;



//ou are given the head of a linked list of length n. Unlike a singly linked list, each node contains an additional pointer random, which may point to any node in the list, or null.
//
//Create a deep copy of the list.
//
//The deep copy should consist of exactly n new nodes, each including:
//
//The original value val of the copied node
//A next pointer to the new node corresponding to the next pointer of the original node
//A random pointer to the new node corresponding to the random pointer of the original node
//Note: None of the pointers in the new list should point to nodes in the original list.
//
//Return the head of the copied linked list.
//
//In the examples, the linked list is represented as a list of n nodes. Each node is represented as a pair of [val, random_index] where random_index is the index of the node (0-indexed) that the random pointer points to, or null if it does not point to any node.
//
//Example 1:
//
//
//
//Input: head = [[3,null],[7,3],[4,0],[5,1]]
//
//Output: [[3,null],[7,3],[4,0],[5,1]]
public class CopyLinkedListWithRandomPointer {
	   public NodeList copyRandomList(NodeList head) {
		   NodeList curr = head;    
		     HashMap <NodeList, NodeList> nodeMap = new HashMap<>(); 
		     while(head!=null){
		    	 NodeList newNode = new NodeList(head.val); 
		          nodeMap.put(head, newNode); 
		          head = head.next; 
		     }

		    
		    for(Map.Entry<NodeList,NodeList> entry : nodeMap.entrySet()){
		    	NodeList newNode  = entry.getValue();
		    	NodeList old = entry.getKey(); 
		        newNode.next = nodeMap.get(old.next); 
		         //newNode.random = nodeMap.get(old.random);  
		    }

		    return nodeMap.get(curr); 

		        
		    }
}
