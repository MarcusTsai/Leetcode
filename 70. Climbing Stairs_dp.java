public class Solution {
    public int climbStairs(int n) {
        if (n<=2) {
           return n;    
        }  
        int [] dp = new int[n+1];
        
        // n = 0
        dp[0] = 0;
        // n = 1
        dp[1] = 1;
        // n = 2
        dp[2] = 2;
        
        for (int i=3; i<=n; i++) {
           /* if ith step is from (i-1)th and jump 1 step, there is dp[i-1] methods
            * if ith step if from (i-2)th and jump 2 steps, there is dp[i-2] methods
            */
           dp[i] = dp[i-1] + dp[i-2];    
        }
        
        return  dp[n];
    }
}