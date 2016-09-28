public class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> current = new ArrayList<>();
       
       if(nums!=null || nums.length != 0){
         helper(result, current, nums);      
       }
       return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> current, int[] nums) {
        if(current.size() == nums.length) {
          result.add(new ArrayList(current));
          return;
        }
        
        for(int i=0; i<nums.length; i++) {
           if(!current.contains(nums[i])) {
             current.add(nums[i]);  
             helper(result, current, nums);
             // restore to the previous status
             current.remove(current.size()-1);
           }    
        }
        
    }
}