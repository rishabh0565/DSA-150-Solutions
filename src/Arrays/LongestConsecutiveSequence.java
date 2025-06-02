package Arrays;

import java.util.HashSet;

//Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.
//
//A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.
//
//You must write an algorithm that runs in O(n) time.
//
//Example 1:
//
//Input: nums = [2,20,4,10,3,4,5]
//
//Output: 4
//Explanation: The longest consecutive sequence is [2, 3, 4, 5].
//
//Example 2:
//
//Input: nums = [0,3,2,5,4,6,1,1]
//
//Output: 7
public class LongestConsecutiveSequence {
	  public int longestConsecutive(int[] nums) {
          HashSet<Integer> set = new HashSet(); 
          for(Integer in : nums){
set.add(in); 
          }
          int longest = 0 ; 
          for(int i= 0 ; i<nums.length ; i++){
            if(!set.contains(nums[i]-1)){
              int count = 1 ;
              int check  = nums[i] + 1;
                while(set.contains(check++)){
                  
                      count++; 
                } 
                if(longest < count){
                    longest = count; 
                }
            }
          }
          return longest;
    }
}
