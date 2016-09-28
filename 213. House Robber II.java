public class Solution {
    public int rob(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    if (nums.length == 1) {
        return nums[0];
    }

    int[] mark1 = new int[nums.length];
    int[] mark2 = new int[nums.length];
    
    // Consider head of the array
    mark1[0] = nums[0];
    mark1[1] = Math.max(nums[1], nums[0]);
    
    // Consider tail of the array
    mark2[0] = 0;
    mark2[1] = nums[1];
    
    for (int i=2; i<nums.length-1; i++) {
        mark1[i] = Math.max(nums[i]+mark1[i-2], mark1[i-1]);
    }
    
    for (int i=2; i<nums.length; i++) {
        mark2[i] = Math.max(nums[i]+mark2[i-2], mark2[i-1]);
    }
    
    return Math.max(mark1[nums.length-2], mark2[nums.length-1]);
    }
}