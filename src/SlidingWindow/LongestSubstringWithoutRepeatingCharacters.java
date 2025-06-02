package SlidingWindow;

import java.util.HashSet;

//Longest Substring Without Repeating Characters
//Given a string s, find the length of the longest substring without duplicate characters.
//
//A substring is a contiguous sequence of characters within a string.
//
//Example 1:
//
//Input: s = "zxyzxyz"
//
//Output: 3
//Explanation: The string "xyz" is the longest without duplicate characters.
//
//Example 2:
//
//Input: s = "xxxx"
//
//Output: 1
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>(); 
       int l = 0;
  int max= 0 ; 
        for (int r = 0; r < s.length(); r++) {
           while(set.contains(s.charAt(r))){
             set.remove(s.charAt(l)); 
             l++;
           }
           set.add(s.charAt(r)); 
           max = Math.max(max, r-l+1); 
        
        } 
         return max; 
    }
}
