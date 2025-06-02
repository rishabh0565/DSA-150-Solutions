package Stack;

import java.util.HashMap;
import java.util.Stack;
//You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
//
//The input string s is valid if and only if:
//
//Every open bracket is closed by the same type of close bracket.
//Open brackets are closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//Return true if s is a valid string, and false otherwise.
//
//Example 1:
//
//Input: s = "[]"
//
//Output: true
//Example 2:
//
//Input: s = "([{}])"
//
//Output: true
//Example 3:
//
//Input: s = "[(])"
//
//Output: false
public class ValidParentheses {
	 public boolean isValid(String s) {
	        Stack<Character> st = new Stack<>(); 
	        HashMap<Character, Character> bracket = new HashMap<>(); 
	        bracket.put(']' , '['); 
	        bracket.put('}' , '{'); 
	        bracket.put(')', '('); 

	        for(char c : s.toCharArray()){
	             if(bracket.containsKey(c)){
	                if(!st.isEmpty() && st.peek() == bracket.get(c)){
	                     st.pop(); 
	                }
	                else{
	                    return false;
	                }        
	              }
	              else{
	                st.push(c); 
	              }
	        }
	       return st.isEmpty(); 
	    }
}
