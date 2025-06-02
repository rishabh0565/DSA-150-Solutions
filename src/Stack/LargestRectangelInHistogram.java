package Stack;

import java.util.Stack;

//You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar is 1.
//
//Return the area of the largest rectangle that can be formed among the bars.
//
//Note: This chart is known as a histogram.
//
//Example 1:
//
//Input: heights = [7,1,7,2,2,4]
//
//Output: 8
public class LargestRectangelInHistogram {
	public int largestRectangleArea(int[] heights) {
	     int max =0  ; 
	     Stack <int[]> stack = new Stack<int[]>(); 
	     for(int i = 0 ; i < heights.length ; i++){
	    	 int start = i ; 
	          while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
	              int[] pop = stack.pop(); 
	              int index = pop[0]; 
	              int height = pop[1]; 
	             max  = Math.max (max, height*  (i - index));
	          start = index; 
	          }
	          stack.push(new int[]{start , heights[i]});
	     }

	          while(!stack.isEmpty()){
	            int [] pair = stack.pop(); 
	              max  = Math.max (max, pair[1] * (heights.length - pair[0]));
	          }
	          return max; 
	     }	    
}
