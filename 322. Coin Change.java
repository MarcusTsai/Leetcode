public class Solution {
  /* if the amount = 100, we have the combination of the coins,
   * which are 1, 5, 10, 25
   * dp[100] = min{dp[75(100-25)], dp[90(100-10)], dp[95(100-5)], dp[99(100-1)]} + 1(the coin)
   */
  }
  public int coinChange(int[] coins, int amount) {
      if(amount<1) return 0;
      Arrays.sort(coins);
      
      int[] dp = new int[amount+1];
      dp[0] = 0;
      
      for(int i=1; i<=amount;i++) {
         int min = Integer.MAX_VALUE;
         for(int coin:coins) {
            if(i-coin<0 || dp[i-coin]==-1) continue;
            min = Math.min(min, dp[i-coins[j]]+1);
             
         }
         dp[i] = (min==Integer.MAX_VALUE)?-1:min;
      }
      return dp[amount];
  }
    
}