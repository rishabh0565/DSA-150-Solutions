package TwoPointer;
//You are given an integer array heights where heights[i] represents the height of the 
//
//
//You may choose any two bars to form a container. Return the maximum amount of water a container can store.
//
//Example 1:
//
//
//
//Input: height = [1,7,2,5,4,7,3,6]
//
//Output: 36
//Example 2:
//
//Input: height = [2,2,2]
//
//Output: 4
public class ContainerWithMostWater {
	 public int maxArea(int[] heights) {
	        int max = 0; int l  = 0; int r = heights.length-1; 
	        while(l<r){            
	         max = Math.max(max,(Math.min(heights[l] , heights[r]) *(r-l))); 
	            if(heights[l] < heights[r]){
	                l++; 
	            }
	            else{
	                r--;
	            }        
	        } 
	        return max;    
	    }
}
