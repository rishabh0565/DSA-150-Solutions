package TwoPointer;
//Given a string s, return true if it is a palindrome, otherwise return false.
//
//A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
//
//Example 1:
//
//Input: s = "Was it a car or a cat I saw?"
//
//Output: true
//Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
//
//Example 2:
//
//Input: s = "tab a cat"
//
//Output: false
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0 ; int end = s.length()-1 ; 
        while(start<end){
         
           while(start<end && !isAlphaNumeric(s.charAt(start))){
             start++; 
           }

           while(start<end && !isAlphaNumeric(s.charAt(end))){
             end--; 
           }
          if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
             return false; 
          }
          start++ ; end--; 
        }
        return true; 
        }
     
     public  boolean isAlphaNumeric(char c){
         if(c>='a' && c<='z' || c>='A' && c<='Z' || c>='0' && c<='9'){
             return true; 
         }
         return false;
     }
}
