package Stack;

import java.util.ArrayList;
import java.util.List;

//You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
//
//Example 1:
//
//Input: n = 1
//
//Output: ["()"]
//Example 2:
//
//Input: n = 3
//
//Output: ["((()))","(()())","(())()","()(())","()()()"]
//You may return the answer in any order.
//
//Constraints:
//
//1 <= n <= 7

public class GenerateParantheses {
	  public List<String> generateParenthesis(int n) {
	        ArrayList<String> result = new ArrayList<String> () ; 
	        int open = 0 ; int close = 0 ; 
	 generateBrackets(open , close, result, n, new StringBuilder(""));
	 return result ; 
	    }
	    public void generateBrackets(int open , int close , ArrayList<String> result , int n, StringBuilder stringBuilder){ 
	        String s = stringBuilder.toString();
	       if(open == n && close == n ){
	            result.add(stringBuilder.toString()); 
	            return;         
	       }  
	        if(open<n) {
		         stringBuilder.append("("); 
		         generateBrackets(open+1 , close , result ,n ,  stringBuilder);
                 stringBuilder.deleteCharAt(stringBuilder.length()-1);      
	       }
	             
	       if(close < open){
	          stringBuilder.append(")") ;     
	            generateBrackets(open , close+1 , result ,n ,  stringBuilder);
	            stringBuilder.deleteCharAt(stringBuilder.length()-1);    
	      }	       
	    } 
}
