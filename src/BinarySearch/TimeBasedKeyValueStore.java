package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeBasedKeyValueStore {
	
	 HashMap<String,ArrayList<String[]>> map; 
	    public TimeBasedKeyValueStore() {
	        map = new HashMap<>(); 
	    }
	    
	    public void set(String key, String value, int timestamp) {
	      if(map.containsKey(key)) {
	    	 String[] arr =  new String[] {String.valueOf(timestamp), value}; 
	    	   map.get(key).add(arr); 
	      }
	    	
	    	map.computeIfAbsent(key, k -> {
	        	 ArrayList<String[]> list = new ArrayList<String[]>();
	        	 String [] arr  = new String[2]; 
	        	 arr[0] = String.valueOf(timestamp);  
	        	 arr[1] =  value; 
	        	 list.add(arr); 
	        	 return list;
	         });
	    }
	    
	    public String get(String key, int timestamp) {
	         if(!map.containsKey(key)) {
	        	  return ""; 
	         }
	         ArrayList<String[]> arrayList = map.get(key); 
	           
	           while(timestamp>=1) {
	        	   int  l = 0 ; int r = arrayList.size()-1; 
	           
	           while(l<=r) {
	        	   int mid = l+(r-l)/2; 
	        	   String time = arrayList.get(mid)[0]; 
	        	   int t = Integer.valueOf(time); 
	        	   if(t < timestamp) {
	        		    l = mid+1; 
	        	   }
	        	   else if(t > timestamp) {
	        		    r = mid -1; 
	        	   }
	        	   else {
	        		    return arrayList.get(mid)[1]; 
	        	   }
	           } timestamp--;
	           }return "";
	           
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	  HashMap<String,TreeMap<Integer,String>> map; 
//	    public TimeBasedKeyValueStore() {
//	        map = new HashMap<>(); 
//	    }
//	    
//	    public void set(String key, String value, int timestamp) {
//	        if(!map.containsKey(key)){
//	            TreeMap<Integer, String> internalMap = new TreeMap<>();
//	            internalMap.put(timestamp, value); 
//	            map.put(key , internalMap);
//	        }
//	        else {
//	          TreeMap<Integer, String> internalMap  =  map.get(key);  
//	            internalMap.put(timestamp, value); 
//	            map.put(key , internalMap);  
//	        }
//	    }
//	    
//	    public String get(String key, int timestamp) {
//	        if(map.containsKey(key)){
//	         TreeMap<Integer, String> internalMap =     map.get(key);
//	          Map.Entry<Integer,String> entry = internalMap.floorEntry(timestamp); 
//	          return entry == null ? "" : entry.getValue(); 
//	        }  
//	        return ""; 
//	    }
}
