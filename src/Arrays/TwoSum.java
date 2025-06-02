package Arrays;

import java.util.HashMap;

//Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
//
//You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
//
//Return the answer with the smaller index first.
//
//Example 1:
//
//Input: 
//nums = [3,4,5,6], target = 7
//
//Output: [0,1]
//Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
//
//Example 2:
//
//Input: nums = [4,5,6], target = 10
//
//Output: [0,2]
//Example 3:
//
//Input: nums = [5,5], target = 10
//
//Output: [0,1]
public class TwoSum {
    public int[] findTwoSum(int [] arr , int target) {
    	HashMap<Integer, Integer> hash = new HashMap<Integer, Integer> ();
    	for(int  i = 0 ; i< arr.length ; i++) {
    		if(hash.containsKey(target-arr[i])) {
    			return new int[] {hash.get(target-arr[i]), i}; 
    		}
    		else {
    			hash.put(arr[i],i); 
    		}
    	}
    	return new int[0]; 
    }
}
