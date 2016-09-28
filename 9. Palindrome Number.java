public class Solution {
    public boolean isPalindrome(int x) {
       /* Palindrome should be positive
        */
       if(x<0) {
         return false;  
       }
       
       if(x>=10) {
         String num = String.valueOf(x);
         int i = 0, j = num.length()-1;
         while(i<j){
            if(num.charAt(i)!=num.charAt(j)) {
              return false;      
            } 
            i++;
            j--;
         }
       }
       return true;
    }
}