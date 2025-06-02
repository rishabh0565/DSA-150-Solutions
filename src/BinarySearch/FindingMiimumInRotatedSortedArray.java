package BinarySearch;
//Find Minimum in Rotated Sorted Array
//Solved 
//You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
//
//[3,4,5,6,1,2] if it was rotated 4 times.
//[1,2,3,4,5,6] if it was rotated 6 times.
//Notice that rotating the array 4 times moves the last four elements of the array to the beginning. Rotating the array 6 times produces the original array.
//
//Assuming all elements in the rotated sorted array nums are unique, return the minimum element of this array.
//
//A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
//
//Example 1:
//
//Input: nums = [3,4,5,6,1,2]
//
//Output: 1
//Example 2:
//
//Input: nums = [4,5,0,1,2,3]
//
//Output: 0
//Example 3:
//
//Input: nums = [4,5,6,7]
//
//Output: 4
public class FindingMiimumInRotatedSortedArray {
	 public int findMin(int[] nums) {
	        int l = 0 ; int r = nums.length-1 ;
	        int res = Integer.MAX_VALUE ; 
	        while(l<=r){
	             if(nums[l] < nums[r]){
	                 res = Math.min(res, nums[l]); 
	                 break ; 
	             }

	             int mid = l + (r-l)/2; 
	             res = Math.min(nums[mid], res); 
	             if(nums[mid] >= nums[l]){
	                 l = mid + 1; 
	             }
	             else {
	                 r = mid -1 ; 
	             }
	        }
	        return res; 
	    }
	 
	 
	 public int findMax(int[] nums) {
	        int l = 0 ; int r =  nums.length-1 ;
	         int res = Integer.MIN_VALUE; 
	         while(l<=r) {
	        	  if(nums[r] > nums[l]) {
	        		   res = Math.max(res, nums[r]); 
	        		   break; 
	        	  }
	        	  int mid = l+(r-l)/2;
	        	  res = Math.max(res, nums[mid]); 
	        	  if(nums[mid] <= nums[l]) {
	        		   r = mid -1; 
	        	  }
	        	  else { 
	        		  l = mid + 1; 
	        	  }
	         }
	         return res; 
	    }
	 
	 
	 
}
