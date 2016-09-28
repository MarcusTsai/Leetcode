public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int base = 0;
        int result = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
           base = i;
           if(map.containsKey(target-nums[i])){
             result = map.get(target-nums[i]);
             break;
           }
           map.put(nums[i], i);   
           
        }
        return new int[]{base, result};
    } 
} 