package Stack;

import java.util.Stack;

//You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
//
//Return the integer that represents the evaluation of the expression.
//
//The operands may be integers or the results of other operations.
//The operators include '+', '-', '*', and '/'.
//Assume that division between integers always truncates toward zero.
//Example 1:
//
//Input: tokens = ["1","2","+","3","*","4","-"]
//
//Output: 5
//
//Explanation: ((1 + 2) * 3) - 4 = 5
//Constraints:
//
//1 <= tokens.length <= 1000.
//tokens[i] is "+", "-", "*", or "/", or a string representing an integer in the range [-100, 100].
public class EvaluateReversePolishNotation {
	 public int evalRPN(String[] tokens) {
	      Stack<Integer> stack = new  Stack<Integer>(); 
	       for(String s : tokens){
	          if(s.equals("+")){
	        	  int a = stack.pop();
	        	  int b = stack.pop(); 
	              stack.push(a+b); 
	          }
	          else if(s.equals("-")){
	        	  int a = stack.pop();
	        	  int b = stack.pop(); 
	              stack.push(a-b); 
	          }
	          else if(s.equals("*")){
	        	  int a = stack.pop();
	        	  int b = stack.pop(); 
	              stack.push(a*b); 
	          }
	          else if(s.equals("/")){
	        	  int a = stack.pop();
	        	  int b = stack.pop(); 
	              stack.push(a/b); 
	          }
	          else{
	              stack.push(Integer.parseInt(s)); 
	          }
	       }
	      return  stack.pop(); 
	    }
}
