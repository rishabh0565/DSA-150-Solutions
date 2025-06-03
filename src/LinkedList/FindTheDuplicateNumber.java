package LinkedList;
//You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n] inclusive.
//
//Every integer appears exactly once, except for one integer which appears two or more times. Return the integer that appears more than once.
//
//Example 1:
//
//Input: nums = [1,2,3,2,2]
//
//Output: 2
//Example 2:
//
//Input: nums = [1,2,3,4,4]
//
//Output: 4
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = 0 ; 
        int fast = 0; 
        while(true){
             slow = nums[slow]; 
             fast = nums[nums[fast]];
             if(slow == fast) break;
        }

        int slow2 = 0 ; 
        while(true){
             slow2 = nums[slow2];
             slow = nums[slow];
             if(slow2 == slow){
                 return slow; 
             }
        }
    }
}
