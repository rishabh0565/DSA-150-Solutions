package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//Permutation in String
//You are given two strings s1 and s2.
//
//Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
//
//Both strings only contain lowercase letters.
//
//Example 1:
//
//Input: s1 = "abc", s2 = "lecabee"
//
//Output: true
//Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
//
//Example 2:
//
//Input: s1 = "abc", s2 = "lecaabee"
//
//Output: false
//Constraints:
//
//1 <= s1.length, s2.length <= 1000
public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length()) return false;
        HashMap<Character , Integer > freqs = new HashMap<>(); 
        HashMap<Character, Integer> freqss = new HashMap<>(); 
        for(char c : s1.toCharArray()){
            freqs.put(c , freqs.getOrDefault(c,0) + 1); 
        }
          
        int l =  0 ; int r = s1.length()-1; 
        while(r<s2.length()){
        	String sub = s2.substring(l,r+1);
           for(char ch : sub.toCharArray() ){
            freqss.put(ch , freqss.getOrDefault(ch,0) + 1); 
             }  
           int count = 0 ; 
             for(Map.Entry<Character, Integer> entry : freqss.entrySet()){
                  int value  = entry.getValue(); 
                  char c = entry.getKey();
                  if(freqs.containsKey(c) && freqs.get(c) == value){
                    count++; 
                  } 
             }
             if(count == freqs.size())
            	 return true; 
             freqss.clear(); 
             l++; r++; 
        }
        return false; 
       
    }
}
