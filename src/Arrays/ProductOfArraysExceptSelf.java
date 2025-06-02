package Arrays;
//Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
//
//Each product is guaranteed to fit in a 32-bit integer.
//
//Follow-up: Could you solve it in 
//O
//(
//n
//)
//O(n) time without using the division operation?
//
//Example 1:
//
//Input: nums = [1,2,4,6]
//
//Output: [48,24,12,8]
//Example 2:
//
//Input: nums = [-1,0,1,2,3]
//
//Output: [0,-6,0,0,0]
public class ProductOfArraysExceptSelf {
	  public int[] productExceptSelf(int[] nums) {
	        int[] prefix = new int[nums.length]; 
	       int[] postfix = new int[nums.length]; 
	       int [] res = new int[nums.length]; 
	       for(int i = 0; i< nums.length ; i++){
	           if(i==0){
	            prefix[i] = nums[0]; 
	           }
	           else{
	             prefix[i] = prefix[i-1]*nums[i];
	           }
	       }
	       for(int j = nums.length -1 ; j>=0 ; j--){
	        if(j == nums.length-1){
	            postfix[j] = nums[j];
	        }
	        else{
	            postfix[j]=postfix[j+1]*nums[j]; 
	        }
	       }
	       for(int k = 0 ; k<nums.length ; k++){
	          if(k==0){
	            res[k] = 1*postfix[k+1]; 
	          }
	          else if(k==nums.length-1){
	            res[k] = 1*prefix[k-1]; 
	          }
	          else{
	            res[k] = prefix[k-1] * postfix[k+1]; 
	           }
	       }
	       return res; 
	    }
}
