public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n==1) {
           return true;    
        }
        if (n<=0 || n%3!=0) {
           return false;    
        }
        
        while(n>=3 && n%3==0) {
          if(n==3){
            return true;  
          }
          n = n/3;
        }
        
        return false;   
    }
}