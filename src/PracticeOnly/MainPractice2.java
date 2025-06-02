package PracticeOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import Arrays.Main;

public class MainPractice2 {
	
	public static void main(String [] args) {
		System.out.println(checkInclusion("adc", "dcda")); 
	}
   
	public  static boolean checkInclusion(String s1, String s2) {
	       HashMap<Character,Integer> map1 = new HashMap<>(); 
	      
	        if(s1.length() > s2.length()){
	             return false; 
	        }
	        // first string freq map 
	       for(char c : s1.toCharArray()){
	           map1.put(c, map1.getOrDefault(c,0) +1); 
	       }

	       // second string we will check each time the combination by 
	       // fixed sliding window 

	       int l = 0; int fl = s1.length(); 
	       for(int r = fl-1; r<s2.length() ; r++,l++){
	          String subString = s2.substring(l, r+1); 
	          HashMap<Character,Integer> map2 = new HashMap<>(); 
	           for(char c : subString.toCharArray()){
	           map2.put(c, map2.getOrDefault(c,0) +1); 
	          }
	           int  count = 0 ;
	          for( Map.Entry<Character, Integer> entry : map1.entrySet()){
	              char ch = entry.getKey(); 
	              int f = entry.getValue(); 
	              
	              if(map2.containsKey(ch) && map2.get(ch)==f){
	                 count++;  
	              }

	          }
	          if(map1.size() == count){
	        	   return true; 
	          }

	       }
	       return false; 


	    }
	
	
	
	public static int search(int[] nums, int target) {
        int l = 0 ; int r = nums.length - 1 ; 
        while (l<=r){
             int mid = l+(r-l)/2 ; 
             if(nums[mid] == target ){
                return mid; 
             }
             else if(nums[mid]>=nums[l]){
                   if(target < nums[mid] && target >= nums[l]) {
                     r = mid-1; 
                   }
                   else{
                      l = mid +1 ;  
                   }
             }
             else {
                 if (target> nums[mid] && target<= nums[r] ){
                    l  = mid +1 ; 
                 }
                 else{
                     r = mid-1; 
                 }
             }
        }   return -1; 
    }
	
	  public static int minEatingSpeed(int[] piles, int h) {
			 int l = 1; 
	         int r = Arrays.stream(piles).max().getAsInt();
			   int res = r; 
			      while (l<=r){
			         int mid = l+(r-l)/2; 
			         int k = mid; 
			          int sum  = 0 ; 
			         for(int i = 0 ; i<piles.length ; i++) { 
			             sum += (int) Math.ceil((double)piles[i]/k);
			         }
			        if(sum > h){
			            l = k+1;  
			        }
			        else if (sum <= h){
			            res =  Math.min(res,k); 
			             r =k -1  ; 
			        }
			      }
			      return res; 		      	        
			    }
	
	public static List<String> findSubsequence(String s , String[] strings){
		 List<String> result = new ArrayList<>(); 
		 
		  char [] arr = s.toCharArray(); 
		 
		  for(String str : strings) {
			  if(str.length()==0) {
				  continue;
			  }
			   int l = 0 ;  int current = 0 ; 
			   while(l<str.length() && current<arr.length) {
				    if(arr[current] == str.charAt(l)) {
				    	 current++; l++; 
				    }
				    else {
				    	 current++; 
				    }
			   }
			   if(l>=str.length()) {
				  result.add(str); 
			   }
		  }
		 return result; 
	}
	
	
	
	  public static int largestRectangleArea(int[] heights) {
	        int largest = 0 ; 
	        Stack<int[]> stack =  new Stack<>(); 
	        for(int i = 0 ; i< heights.length ; i++){
	            int start = i ; 
	            while(!stack.isEmpty() && stack.peek()[0] > heights[i]){
	               int[] pop =  stack.pop(); 
	               int h = pop[0]; 
	               int index = pop[1]; 
	               largest = Math.max(largest , h * (i-index)); 
	               start = index; 
	            }
	            stack.push( new int[]{heights[i] , start}); 
	        }
	        for(int[] pop: stack){
	             int h = pop[0]; 
	             int index = pop[1]; 
	            largest = Math.max(largest,  h * (heights.length - index)); 
	        }
	        return largest; 
	    }
	
	
	//.............
	public static  int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2]; 
        for(int i = 0 ; i < position.length ; i++){
            cars[i][0] = position[i]; 
            cars[i][1] = speed[i]; 
        }
       Arrays.sort(cars, (a,b)-> Integer.compare(a[0] , b[0])); 
       Stack<Double> stack = new Stack<>();  
       for(int i  = cars.length-1 ;  i>=0 ; i--) {
             double pos = cars[i][0];
             double sp = cars[i][1]; 
               double time  =   ((target-pos)/sp);
             if(stack.isEmpty()){
                stack.push(time); 
             }
             else if(stack.peek() < time){
                 stack.push(time); 
             }
       }
       return stack.size(); 

   }
	/////
	
	
	public  static int[] dailyTemperatures(int[] temperatures) {
        Stack <int[]> stack = new Stack<>(); 
        int[] arr = new int[temperatures.length]; 
        for(int i = 0 ; i < temperatures.length ; i++){
             if(stack.isEmpty()){
                 stack.push(new int[]{temperatures[i] , i});
             }
             else if(stack.peek()[0] >= temperatures[i]){
                 stack.push(new int[]{temperatures[i] , i}); 
             }
             else{
               int[] pop =   stack.pop();
               int index = pop[1]; 
               arr[index] = i-index;  
               stack.push(new int[] {temperatures[i] , i}); 
             }
        }
        return arr; 
    }
	////////////////////////////////
	  public static List<String> generateParenthesis(int n) {
	         ArrayList<String> arr = new ArrayList<>();
	       generate(0,0,arr, n , new StringBuilder("")); 
	       return arr; 
	    }

	    public static  void generate(int open, int close , ArrayList<String> result , int n, StringBuilder s ){
	         
	    	 if(open == n && close == n){
	              result.add(s.toString()); 
	             return ; 
	          }
	          if(open<n){
	             s.append("("); 
	             generate( open+1 , close,result , n , s ); 
	             s.deleteCharAt(s.length()-1); 
	          }
	          if(close<open){
	            s.append(")"); 
	             generate(open, close+1,result,n, s); 
	             s.deleteCharAt(s.length()-1); 
	          }
	    }
	
	// .....................
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 
        for(char c : s.toCharArray()){
            if(c == '(') {
                stack.push(c); 
            }
            else if(c == '{') {
                stack.push(c); 
            }
            else if(c == '[') {
                stack.push(c); 
            }
            else if(c == ')') {
                 if( !(stack.pop() == '(')){
                    return false;
                 } 
            }
            else if(c == '}') {
                 if( !(stack.pop() == '}')){
                    return false;
                 } 
            }
            else if(c == ']') {
                 if( !(stack.pop() == '[')){
                    return false;
                 } 
            }
        }
        return true; 
   }
	
	//////
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
	System.out.println(	Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<>(); 
         for(int i = 0 ; i<nums.length ; i++){
        	  if (nums[i] > 0) break;
              if (i > 0 && nums[i] == nums[i - 1]) continue;
             int first = nums[i]; 
             int l = i+1; int r = nums.length-1; 
             while(l<r){
            	 int second = nums[l]; 
                 int third = nums[r]; 
                 int sum =   nums[l] +nums[r] + first ;
                
                 if( sum<0) {
                	  l++; 
                 }
                 else if( sum>0) {
                	 r--; 
                 }
               
                 else {
                     List<Integer> li = new ArrayList<>(); 
                    li.add(first);
                    li.add(second);
                    li.add(third); 
                    res.add(li); 
                    l++ ; r--; 
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
                 
             }
         }
         return res; 
    }
	
	
	
	
	
	
	
	
	
	
	
	//
	  public static  boolean isPalindrome(String s) {
	        int l = 0 ; int  r = s.length()-1; 
	        for(int i = 0 ; i < s.length()&&l<r ; i++){ 
	            while( l<=r && !isAlphaNumeric (s.charAt(l))){
	                l++;  
	            }

	            while(l<=r && !isAlphaNumeric(s.charAt(r))){
	                r--;  
	            }
	            if(Character.toLowerCase( s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
	                  return false;
	            }
	            l++; r--; 
	        }
	        return true; 
	    }

	    public static  boolean isAlphaNumeric(char c){
	         if((c>='0' && c<='9') || (c>='a' && c<='z') || (c>='A' && c<='Z')){
	             return true;
	         }
	         return false;
	    }
	
	
	
	
	
	
	
	
	
	//////////////////////
	  public static int[] productExceptSelf(int[] nums) {
	        int[] prefix = new int[nums.length]; 
	        int[] postfix = new int[nums.length]; 
	        for(int i = 0 ; i< nums.length ; i++){
	              if(i==0)
	               prefix[i] = nums[i];

	              else 
	                prefix[i] = nums[i]*prefix[i-1];   
	        }

	        for(int i = nums.length-1 ; i>=0 ; i--){
	              if(i==nums.length-1)
	               postfix[i] = nums[i];

	              else 
	                postfix[i] = nums[i]*postfix[i+1];   
	        }

	        int[] res = new int[nums.length]; 
	        for(int i = 0 ; i<res.length  ; i++){
	             if(i==0){
	                     res[i] =  postfix[i+1]; 
	             }
	             else if(i==nums.length-1){
	                  res[i] = prefix[i-1]; 
	             }
	             else{
	                 res[i] = prefix[i-1]*postfix[i+1]; 
	             }
	        }
	        return res; 

	    }
	public static String encode(List<String> strs) {
	       StringBuilder sb = new StringBuilder();
	       for(String s : strs){
	           sb.append(s.length());
	           sb.append("#");
	           sb.append(s);         
	       }
	       return sb.toString();
	    }

	    public static List<String> decode(String str) {
	         List<String> list = new ArrayList<>(); 
	         int pos = 0; 
	         while(pos<str.length()){ 
	            String no = ""; 
	            while(str.charAt(pos) !='#'){
	                 no+=str.charAt(pos); 
	                 pos++; 
	            }
	            pos+=1;
	            int num = Integer.valueOf(no); 
	           String res = "";
	            for(int i = 1 ; i<=num ; i++ ){
	                res+=str.charAt(pos++); 
	            }
	            list.add(res);    
	          }
	     return list;
	         }
	
	
	public static int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer>[] arr = new ArrayList[nums.length+1];
        HashMap<Integer, Integer> freq   = new HashMap<>() ;

        for(int i = 0 ; i<arr.length ; i++){
             arr[i] = new ArrayList<>(); 
        }
        for(int a : nums){
             freq.put(a, freq.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            arr[entry.getValue()].add(entry.getKey()); 
        }
        int [] res = new int[k]; int pos = 0 ;
       for(int  i = arr.length-1 ; (i > 0 && pos<k) ; i--){ 
            for(int a :arr[i]){
                  res[pos++] = a; 
                  k++; 
            }
       }
       return res; 
    }
	
	
	 public static int[] twoSum(int[] nums, int target) {
	        HashMap<Integer, Integer> map = new HashMap<>(); 
	        for(int i = 0 ; i<nums.length ; i++){
	             if(map.containsKey(target-nums[i])){ 
	               return new int[]{map.get(target-nums[i]) , i} ;
	             }
	             map.put(nums[i] , i ); 
	        }  return new int[]{0,0}; 
	    }
}
