package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
//
//After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
//
//Example 1:
//
//Input: s = "XYYX", k = 2
//
//Output: 4
//Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
//
//Example 2:
//
//Input: s = "AAABABB", k = 1
//
//Output: 5
public class LongestRepeatingCharacterReplacement {
	
	 public int characterReplacement(String s, int k) {
	        HashMap<Character, Integer> freq = new HashMap<>(); 
	        int l = 0 ; 
	        int res = 0 ; 
	        int maxf= 0 ; 
	        for(int r = 0 ; r<s.length() ; r++){
	            freq.put(s.charAt(r) , freq.getOrDefault(s.charAt(r), 0) + 1);
	            maxf = Math.max(maxf, freq.get(s.charAt(r))); 
	             if(r-l+1-maxf <=k){
	                 res = Math.max(res , r-l+1);                
	             }
	             else{
	               while(r-l+1-maxf >k){
	                 freq.put(s.charAt(l), freq.get(s.charAt(l)) -1);
	                 l+=1; 
	               }            
	             }
	        }
	        return res;
	    }
}
