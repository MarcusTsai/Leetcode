public class Solution {
    public int trailingZeroes(int n) {
        /*
         * Since multiple of 2 is more than multiple of 5, 
         * the number of zeros is dominant by the number of 5.
         * use division to find factor 5
         */
        int count = 0;
        
        while(n>1) {
            count+= n/5;  
            n = n/5;
        }
        return count;
    }
}