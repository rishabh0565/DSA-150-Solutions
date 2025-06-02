package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an integer array nums and an integer k, return the k most frequent elements within the array.
//
//The test cases are generated such that the answer is always unique.
//
//You may return the output in any order.
//
//Example 1:
//
//Input: nums = [1,2,2,3,3,3], k = 2
//
//Output: [2,3]
//Example 2:
//
//Input: nums = [7,7], k = 1
//
//Output: [7]
public class TopKFrequentElement {
   public int[] findFrequentElement(int[] nums, int k) {
	   Map<Integer, Integer> count = new HashMap<>(); 
	      for(int i = 0 ; i<nums.length ;  i++){
	           count.put(nums[i], count.getOrDefault(nums[i],0)+1);
	      }
	      List<Integer>[] freq =  new ArrayList[nums.length+1];
	      for(int j = 0; j<nums.length+1 ; j++){
	        freq[j] = new ArrayList<Integer>(); 
	      }

	      for(Map.Entry<Integer,Integer> entry : count.entrySet()){ 
	          freq[entry.getValue()].add(entry.getKey()); 
	      }
	      
	      int[] res = new int[k]; 
	      int index = 0;  
	     for(int m = freq.length-1 ; m>=0 && index<k ; m--){
	        for(int n : freq[m]){
	            res[index++] =  n; 
	            if(index == k ){
	                return res; 
	            }
	        }
	     }
	     return res; 
   }
}
