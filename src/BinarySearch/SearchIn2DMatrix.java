package BinarySearch;
//You are given an m x n 2-D integer array matrix and an integer target.
//
//Each row in matrix is sorted in non-decreasing order.
//The first integer of every row is greater than the last integer of the previous row.
//Return true if target exists within matrix or false otherwise.
//
//Can you write a solution that runs in O(log(m * n)) time?
//
//Example 1:
//
//
//
//Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
//
//Output: true
public class SearchIn2DMatrix {
	 public boolean searchMatrix(int[][] matrix, int target) {
	        int  rows = matrix.length-1 ; int cols = matrix[0].length-1; 
	        int top = 0 ; int bot = rows; int mid = 0 ; 
	        while(top<=bot){
	             mid = top+(bot-top)/2; 
	              if(matrix[mid][0] > target){
	                 bot = mid - 1; 
	              }
	              else if (matrix[mid][cols] < target){
	                 top = mid+1 ; 
	              }
	              else{
	                 
	                 break; 
	              }
	        }

	        if(top>bot){
	            return false; 
	        }
	       int left = 0 ; int right = cols; 
	        while(left<=right){
	             int mid2 = left+(right-left)/2; 
	              if(matrix[mid][mid2] > target){
	                 right = mid2 - 1; 
	              }
	              else if (matrix[mid][mid2] < target){
	                 left = mid2+1 ; 
	              }
	              else{
	                  return true; 
	              }
	        }

	         return false;

	    }
}
