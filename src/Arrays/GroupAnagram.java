package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
//
//An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
//
//Example 1:
//
//Input: strs = ["act","pots","tops","cat","stop","hat"]
//
//Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
//Example 2:
//
//Input: strs = ["x"]
//
//Output: [["x"]]
public class GroupAnagram {
    public List<List<String>> findGroupAnagram(String[] strs) {
    	 HashMap <String , ArrayList<String>> mainMap = new HashMap<String , ArrayList<String> >(); 
         
         for (int i = 0 ; i < strs.length ; i++){
             int[] count = new int[26]; 
             for(Character c : strs[i].toCharArray()){
                 count[c - 'a']++; 
             }
               String key = Arrays.toString(count); 
mainMap.computeIfAbsent(key, k -> new ArrayList<String>()).add(strs[i]); 
         }
       return new ArrayList<>(mainMap.values());
    }
}
