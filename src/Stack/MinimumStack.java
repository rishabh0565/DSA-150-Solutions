package Stack;

import java.util.ArrayList;
import java.util.Stack;
//Design a stack class that supports the push, pop, top, and getMin operations.
//
//MinStack() initializes the stack object.
//void push(int val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//Each function should run in 
//O
//(
//1
//)
//O(1) time.
//
//Example 1:
//
//Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
//
//Output: [null,null,null,null,0,null,2,1]
//
//Explanation:
//MinStack minStack = new MinStack();
//minStack.push(1);
//minStack.push(2);
//minStack.push(0);
//minStack.getMin(); // return 0
//minStack.pop();
//minStack.top();    // return 2
//minStack.getMin(); // return 1
public class MinimumStack {
	public ArrayList<Integer> stack; 
    Stack<Integer> minStack; 
   public MinimumStack() {
       this.stack = new ArrayList<>();
       this.minStack =  new Stack<>(); 
   }
   
   public void push(int val) {
              stack.add(val);
         if (minStack.isEmpty() || val <= minStack.peek()) {
           minStack.push(val);
       }
   }
   
   public void pop() {
      if(stack.isEmpty()) return; 
      int top = stack.get(stack.size() - 1); 
      stack.remove(stack.size() - 1); 
      if(top == minStack.peek()){
       minStack.pop(); 
      }
   }
   
   public int top() {
       return stack.get(stack.size() -1); 
   }
   
   public int getMin() {
       return minStack.peek();  
   }
}
