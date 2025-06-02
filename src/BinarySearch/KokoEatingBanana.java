package BinarySearch;

import java.util.Arrays;

//You are given an integer array piles where piles[i] is the number of bananas in the ith pile. You are also given an integer h, which represents the number of hours you have to eat all the bananas.
//
//You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, you may finish eating the pile but you can not eat from another pile in the same hour.
//
//Return the minimum integer k such that you can eat all the bananas within h hours.
//
//Example 1:
//
//Input: piles = [1,4,3,2], h = 9
//
//Output: 2
//Explanation: With an eating rate of 2, you can eat the bananas in 6 hours. With an eating rate of 1, you would need 10 hours to eat all the bananas (which exceeds h=9), thus the minimum eating rate is 2.
//
//Example 2:
//
//Input: piles = [25,10,23,4], h = 4
//
//Output: 25
public class KokoEatingBanana {
	  public int minEatingSpeed(int[] piles, int h) {
			 int l = 1; 
	         int r = Arrays.stream(piles).max().getAsInt();
			   int res = r; 
			      while (l<=r){
			         int mid = l+(r-l)/2; 
			         int k = mid; 
			          int sum  = 0 ; 
			         for(int i = 0 ; i<piles.length ; i++) { 
			             sum += (int) Math.ceil((double)piles[i]/k);
			         }
			        if(sum > h){
			            l = k+1;  
			        }
			        else if (sum <= h){
			            res =  Math.min(res,k); 
			             r =k -1  ; 
			        }
			      }
			      return res; 		      	        
			    }
}
