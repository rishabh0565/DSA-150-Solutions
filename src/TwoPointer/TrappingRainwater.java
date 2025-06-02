package TwoPointer;

public class TrappingRainwater {
	 public int trap(int[] height) {
	        int [] maxPrefix  =  new int[height.length]; 
	        int [] maxPostfix  =  new int[height.length]; 
	        int res = 0; 
	        for(int i = 0 ; i < height.length ; i++){
	        	if(i==0) {
	        		maxPrefix[i] = height[i]; 
	        	}
	        	else {
	            maxPrefix[i] = Math.max(maxPrefix[i-1], height[i]); 
	        	}}
	         for(int i = height.length-1 ; i>=0 ; i--){
	       if(i==height.length-1)
	    	   maxPostfix[i] = height[i]; 
	        	 else
	        	 maxPostfix[i] = Math.max(maxPostfix[i+1], height[i]); 
	        }

	        for(int i = 0 ; i < height.length ; i++){
	          res+=  Math.min (maxPrefix[i], maxPostfix[i]) - height[i] ;  
	        }
	        return res; 
	    }
	 
	 //  this can also be done with 2 pointer approcach logic is same just we will not use any 
	 // new array to store prefix and postfix. 
	  
	 public int trap2(int [] arr) {
		 int l = 0 ; int r = arr.length-1; 
		 int res = 0 ; int leftMax = arr[l] ; int rightMax = arr[r]; 
	 
		 while(l<r) {
			 if(leftMax < rightMax) {
				 l++; 
				 leftMax = Math.max(leftMax, arr[l]); 
				 res+= leftMax-arr[l]; 
			 }
			 else {
				 r--; 
				 rightMax = Math.max(rightMax, arr[r]); 
				 res+=rightMax-arr[r]; 
			 }			 		 
		 }
		 
		 return res; 
	 }
	 
}
