package PracticeOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class MainPractice {
	public static void main(String[] args) {
//		 System.out.println( isValidSudoku(new char[][] {
//			 {'1','2','.','.','3','.','.','.','.'},
//			 {'4','.','.','5','.','.','.','.','.'},
//			 {'.','9','1','.','.','.','.','.','3'},
//			 {'5','.','.','.','6','.','.','.','4'},
//			 {'.','.','.','8','.','3','.','.','5'},
//			 {'7','.','.','.','2','.','.','.','6'},
//			 {'.','.','.','.','.','.','2','.','.'},
//			 {'.','.','.','4','1','9','.','.','8'},
//			 {'.','.','.','.','8','.','.','7','9'}}));
		System.out.println(carFleet(10, new int[] {6,8}, new int[] {3,2}));
	}
	
	public static int carFleet(int target, int[] position, int[] speed) {
	       int[][] ps  = new int[position.length][2]; 
	        for(int i = 0 ; i < position.length ; i++){
	             ps[i][0] = position[i]; 
	             ps[i][1]  = speed[i]; 
	        }
	        Arrays.sort(ps , (a,b) -> Integer.compare(a[0] , b[0])); 
	          Stack<Double> stack =  new Stack<>(); 
	       for(int i = position.length -1 ; i>=0 ; i--){
	           double time = (double)(( target -  ps[i][0] ) / ps[i][1]); 
	           if(!stack.isEmpty() && time>stack.peek()){
	              stack.push(time); 
	           }
	           else if(stack.isEmpty()){
	             stack.push(time); 
	           }
	       }
	return stack.size() ; 
	     }
	
	 public static boolean isValidSudoku(char[][] board) {
	       
		  HashMap<Integer, HashSet<Character>> rows =  new HashMap<Integer, HashSet<Character>>();

		  HashMap<Integer, HashSet<Character>> cols =  new HashMap<Integer, HashSet<Character>>();

		  HashMap<String, HashSet<Character>> square =  new HashMap<String,HashSet<Character>>();

		  for(int i = 0 ; i < board[0].length ; i++) {
			  for(int j = 0 ; j<board.length ; j++) {
				    if(board[i][j] == '.') {
				    	continue; 
				    }
				    else {
				    	  String s = i/3+"_"+ j/3;  
				    	if(rows.computeIfAbsent(i, k->new HashSet<Character>()).contains(board[i][j]) || cols.computeIfAbsent(i, k->new HashSet<Character>()).contains(board[i][j]) || square.computeIfAbsent(s, k->new HashSet<Character>()).contains(board[i][j]) ) {
				    		return false; 
				    	}
				    	rows.get(i).add(board[i][j]); 
				    	cols.get(i).add(board[i][j]); 
				    	square.get(s).add(board[i][j]); 
				    }
			  }
		  }
		  
		  return true; 
	 
	 } 
	  public static int[] topKFrequent(int[] nums, int k) {
	       ArrayList<Integer>[] res = new ArrayList[nums.length];
	        HashMap<Integer, Integer> map = new HashMap<>(); 
	        for(int i = 0 ; i<nums.length ; i++){
		         res[i] = new ArrayList<Integer>();
		       } 
	       for(int i = 0 ; i<nums.length ; i++){
	          map.put(nums[i],  map.getOrDefault(nums[i], 0)  + 1); 
	       } 
	       for(Map.Entry<Integer,Integer> entry : map.entrySet()){
	           res[entry.getValue()-1].add(entry.getKey());  
	       }
	        int [] ans = new int[k];
	       for(int j = nums.length-1 ,  m = 0  ; j>=0 &&  m<=k; j-- ){
	             for( int a : res[j]){
	                  if(m+1>k){
	                    break; 
	                  }
	                  ans[m] = a; 
	                  m++; 
	             }  
	       }
	       return ans;
	       
	    }
	
	
	 public static List<List<String>> groupAnagrams(String[] strs) {
	        HashMap<String, ArrayList<String>> map =  new HashMap<>(); 
	        List<List<String>> res = new ArrayList<>(); 
	        for(String s : strs){ 
	               int[] arr = new int[26]; 
	               for(char c : s.toCharArray()){
	                    int index = c-'a'; 
	                    arr[index] = arr[index]+1; 
	               }
	               if(map.containsKey(Arrays.toString(arr))){
	                  map.get(Arrays.toString(arr)).add(s); 
	               } 
	               else{
	            	  ArrayList<String> list = new ArrayList<>();
	            	  list.add(s);
	                  map.put(Arrays.toString(arr) ,list); 
	               }
	        }

	        for( Entry<String, ArrayList<String>> m  : map.entrySet()  ){	             
	                res.add(m.getValue()); 	             
	        }
	        return res; 
	    }
	
	 public static boolean hasDuplicate(int[] nums) {
	        HashSet<Integer> set = new HashSet<>(); 
	        for(int i = 0 ; i< nums.length ; i++){
	            if( set.contains( nums[i])) {
	              return true;
	             }
	            set.add(nums[i]);
	        }
	          return false;
	    }
	 
	    public  static String twoSum(int[] nums, int target) {
	        HashMap<Integer,Integer> map =  new HashMap<>(); 
	        for(int i = 0 ; i < nums.length ; i++) {
	            if(map.containsKey( target-nums[i]) ){
	                return   Arrays.toString( new int[]{map.get(target - nums[i]), i}); 
	            }
	            else{
	                map.put(nums[i] , i); 
	            }
	        }
	        return Arrays.toString( new int[2]); 
	    }
}
