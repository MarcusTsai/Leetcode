public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        Integer result = 0;
        int shift = 31;
        
        while(n!=0) {
           result |= (n & 1) << shift;
           n = n >>>1;
           shift--;
        }
        
        return result;
        
    }

    public int reverseBits(int n) {
      Integer result = 0;
      int power = 31;
      
      while(n!=0) {
         result += (n & 1) * (int)Math.pow(2, power);
         // if use integer to carry 2^31, it will truncate to 2^31 -1
         n = n >>>1;
         power--;
         //System.out.println((int)Math.pow(2, power));
      }
      
      return result;}
        
    }
}