package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
//
//The output should not contain any duplicate triplets. You may return the output and the triplets in any order.
//
//Example 1:
//
//Input: nums = [-1,0,1,2,-1,-4]
//
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//
//Example 2:
//
//Input: nums = [0,1,1]
//
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//
//Example 3:
//
//Input: nums = [0,0,0]
//
//Output: [[0,0,0]]
public class ThreeSum {
	 public List<List<Integer>> threeSum(int[] nums) {
	       List<List<Integer>> result = new ArrayList();
	       Arrays.sort(nums);  
	       for(int i = 0; i <= nums.length-2; i++ ){
	           if(nums[i] > 0 ){
	              break;  
	           }
	           if(i> 0 && nums[i] == nums[i-1] ){
	            continue; 
	           }
	           int l = i+1 ; int r = nums.length-1; 
	           while(l<r){
	        	   int sum = nums[r] + nums[l] + nums[i]; 
	              if(sum > 0 ){
	                r--; 
	              }
	               else if(sum < 0){
	                l++; 
	              }
	              else{
	             ArrayList<Integer>  subList = new ArrayList(); 
	               subList.add(nums[i]); 
	               subList.add(nums[l]); 
	               subList.add(nums[r]); 
	               result.add(subList); 
	               l++ ; r--; 
	               // to avoid duplicates in left index 
	 	          while(l<r && nums[l] == nums[l-1]){
	 	            l++; 
	 	              }
	              }
	        
	           } 
	       }
	       return result; 
	    }
}
