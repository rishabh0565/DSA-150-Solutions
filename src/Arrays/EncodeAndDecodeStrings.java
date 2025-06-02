package Arrays;

import java.util.ArrayList;
import java.util.List;
//Encode and Decode Strings
//Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
//
//Please implement encode and decode
//
//Example 1:
//
//Input: ["neet","code","love","you"]
//
//Output:["neet","code","love","you"]
//Example 2:
//
//Input: ["we","say",":","yes"]
//
//Output: ["we","say",":","yes"]
public class EncodeAndDecodeStrings {
       public String encode(ArrayList<String> strs) {
    	   StringBuilder sb =  new StringBuilder(""); 
           for(String s : strs){
            sb.append(    s + "#");   
           }
           return sb.toString(); 
       }
       
       public List<String> decode(String str) {
    	   char[] arr = str.toCharArray(); 
           List<String> s = new ArrayList<String>(); 
           StringBuilder sb  = new StringBuilder(""); 
           for(Character c : arr){
               if(c!='#'){
     sb.append(c); 
               }
               else{
                   s.add(sb.toString()); 
                   sb.setLength(0);
               }
           }
           return s;  
       }
}
