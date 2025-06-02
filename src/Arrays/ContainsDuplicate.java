package Arrays;

import java.util.HashSet;

//Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
//
//Example 1:
//
//Input: nums = [1, 2, 3, 3]
//
//Output: true
public class ContainsDuplicate {

	public boolean ContainsDuplicates(int[] arr) {
		  HashSet<Integer> set =  new HashSet<Integer>();
		    for(int i = 0 ; i < arr.length ; i++) {
		    	if(set.contains(arr[i])) {
		    		return true;
		    	}
		    	set.add(arr[i]);
		
		    }
		    return false;		    
	}
      
}
