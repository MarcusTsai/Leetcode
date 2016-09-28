public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) {
          return 0;    
        }
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i=1; i<nums.length; i++) {
           int base = nums[i];
           int max = 0;
           for(int j=0; j<i; j++) {
              if(base<=nums[j]) continue; 
              if(dp[j]>max) {
                max = dp[j];   
              } 
           }
           dp[i] += max;
        }
        
        Arrays.sort(dp);
        
        return dp[nums.length-1];   
    }
}