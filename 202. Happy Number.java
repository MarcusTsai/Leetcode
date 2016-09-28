public class Solution {
    public boolean isHappy(int n) {
        int result=0;
        Set<Integer> record = new HashSet<>();
        /*boolean add(Object o)
         * Adds the specified element to this set if it is not already present.
         */
        
        /* loop condition terminates as result repeats
         */
        while(record.add(n)) {
           while(n>0){
             int val = (int)Math.pow(n%10, 2);
             result += val;
             n = n/10;
           }
           if(result==1){
             return true;  
           }
           n = result;
           result = 0;
        }
        
        return false;
    }
}