package Arrays;

import java.util.HashMap;
import java.util.Map.Entry;
//Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
//
//An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
//
//Example 1:
//
//Input: s = "racecar", t = "carrace"
//
//Output: true
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
if(s.length() != t.length()){
    return false;
}
HashMap<Character, Integer> sh = new HashMap<Character, Integer>(); 
 HashMap<Character, Integer>  th = new HashMap<Character, Integer>(); 
 for(int i = 0 ; i  < s.length() ; i++){
    if(sh.containsKey(s.charAt(i))){
       sh.put(s.charAt(i), sh.get(s.charAt(i)) + 1);   
    }
    else{
  sh.put(s.charAt(i), 1 ); 
    }
     if(th.containsKey(t.charAt(i))){
       th.put(t.charAt(i), th.get(t.charAt(i)) + 1);   
    }
    else{
           th.put(t.charAt(i),1); 
    }
  
 }
 for(Entry<Character, Integer> entry : sh.entrySet()){
     Character c =  entry.getKey();
      int v  = entry.getValue(); 
      if(!th.containsKey(c)){
        return false; 
      }
      else{
        if(th.get(c) != v){
              return false; 
        }
      }
 }
 return true; 

    }
}
