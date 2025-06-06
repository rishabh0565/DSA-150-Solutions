package LinkedList;

import java.util.HashMap;

//Implement the Least Recently Used (LRU) cache class LRUCache. The class should support the following operations
//
//LRUCache(int capacity) Initialize the LRU cache of size capacity.
//int get(int key) Return the value corresponding to the key if the key exists, otherwise return -1.
//void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the introduction of the new pair causes the cache to exceed its capacity, remove the least recently used key.
//A key is considered used if a get or a put operation is called on it.
//
//Ensure that get and put each run in 
//O
//(
//1
//)
//O(1) average time complexity.
//
//Example 1:
//
//Input:
//["LRUCache", [2], "put", [1, 10],  "get", [1], "put", [2, 20], "put", [3, 30], "get", [2], "get", [1]]
//
//Output:
//[null, null, 10, null, null, 20, -1]
//
//Explanation:
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 10);  // cache: {1=10}
//lRUCache.get(1);      // return 10
//lRUCache.put(2, 20);  // cache: {1=10, 2=20}
//lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
//lRUCache.get(2);      // returns 20 
//lRUCache.get(1);      // return -1 (not found)
public class LRUCache {
	ListNode lru = new ListNode(0); 
	  ListNode mru = new ListNode(0);
	    int length = 0 ; 
	    HashMap<Integer, ListNode> map = new HashMap<>(); 
	    public LRUCache(int capacity) {
	        length = capacity; 
	        lru.next = mru; 
	        mru.prev = lru; 
	    }
	    
	    public int get(int key) {
	        if(map.containsKey(key)){
	            // remove ll current index 
	        	ListNode node =  map.get(key); 
	            removeFromLL(node); 
	            // add it as a MRU
	             addAsMru(node);
	            return node.val;
	        }
	        else { 
	            // do nothing
	           return  -1; 
	        }
	    }

	    public void removeFromLL(ListNode node){

	        node.prev.next  = node.next; 
	        node.next.prev = node.prev; 
	    }

	    public void addAsMru(ListNode node){
	    	ListNode last =  mru.prev; 
	         last.next = node; 
	         node.prev = last; 
	         node.next = mru; 
	         mru.prev = node; 
	    }
	    
	    public void put(int key, int value) {
	         if(map.containsKey(key)){
	        	 ListNode node = map.get(key);
	            node.val = value;
	             removeFromLL(node);   
	             addAsMru(node); 
	        }
	        else if(map.size() == length){
	             map.remove(lru.next.key); 
	             removeFromLL(lru.next);
	             map.put(key, new ListNode(key,value)); 
	             addAsMru(map.get(key)); 
	        }
	        else{
	            map.put(key, new ListNode(key,value));
	            addAsMru(map.get(key)); 
	        }
	    }

}

