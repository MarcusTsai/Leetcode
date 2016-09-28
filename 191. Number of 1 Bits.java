public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        /* input 2147483648 would correspond to -2147483648 in java 
         * and the code would not enter the while 
         * if the condition is n>0 for n=2147483648.
         * note: Java as -2147483648 (in java int type has a cyclic representation, 
         * that means Integer.MAXVALUE+1==Integer.MINVALUE).
         */
        while(n!=0) {
          count += n & 1;
          
          /* We need to use bit shifting unsigned operation >>> 
           *(while >> depends on sign extension)
           */
          n = n>>>1;
        }
        return count;
    }
}