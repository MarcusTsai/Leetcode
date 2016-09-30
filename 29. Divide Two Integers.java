public class Solution {
    public int divide(int dividend, int divisor) {
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if(ldividend<ldivisor) return 0;

        long res=0;
        int sign = (dividend^divisor) >> 31;
        
        if(divisor==0) return Integer.MAX_VALUE;
        
        while(true){
            int shift = 0;
            /*
             * Shift ahead in order to avoid shift back
             */
            while (ldividend>=(ldivisor<<(shift+1))) {
               shift++;
            }

            ldividend -= (ldivisor<<shift);
            res += (long)1<<shift;

            if(ldividend-ldivisor<0) break;
        }

        if((sign==0) && (res>=Integer.MAX_VALUE)) {
            res = Integer.MAX_VALUE;
        } 
        return (int)(sign==0 ? res: -res);
    }
}