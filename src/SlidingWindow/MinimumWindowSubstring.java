package SlidingWindow;

import java.util.HashMap;

//Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
//
//You may assume that the correct output is always unique.
//
//Example 1:
//
//Input: s = "OUZODYXAZV", t = "XYZ"
//
//Output: "YXAZ"
//Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.
//
//Example 2:
//
//Input: s = "xyz", t = "xyz"
//
//Output: "xyz"
//Example 3:
//
//Input: s = "x", t = "xy"
//
//Output: ""
public class MinimumWindowSubstring {
	 public String minWindow(String s, String t) {
		    if(s.length() < t.length()) {
		    	return ""; 
		    }
	        HashMap<Character, Integer> needMap = new HashMap<>(); 
	        HashMap<Character , Integer> haveMap = new HashMap<>(); 
	        for(char c : t.toCharArray()){
	             needMap.put(c, needMap.getOrDefault(c, 0 ) + 1); 
	        }
	        int[] res = new int[]{0,0};   int size = Integer.MAX_VALUE ; 
	        int l = 0 ; int have  = 0 ; int need = needMap.size(); 
	        for(int r = 0 ; r<s.length() ; r++){
	              if(needMap.containsKey(s.charAt(r))){
	            	  haveMap.put(s.charAt(r), haveMap.getOrDefault(s.charAt(r), 0) + 1);
	            	  if(haveMap.containsKey(s.charAt(r))) {
		                	 if(needMap.get(s.charAt(r)) ==haveMap.get(s.charAt(r))){
		                		 have++; 
		                	 }
		                 }
	                      // now increment l after adding result 
	                     while(have==need ){
	                                if(size > r-l+1){
	                                res[0] = l ; 
	                                 res[1] = r ;
	                                 size =  r-l+1; 
	                               }
	                          if(needMap.containsKey(s.charAt(l))){
	                        	  haveMap.put(s.charAt(l), haveMap.get(s.charAt(l)) -1 ); 
	                        	  if(haveMap.get(s.charAt(l)) < needMap.get(s.charAt(l))) {
	                        		  have--;
	                        	  }           
	                          } l++;
	                     }
	                  }
	              }
	        

	        return  size==Integer.MAX_VALUE ? "" :  s.substring(res[0], res[1]+1); 
	    }
}
