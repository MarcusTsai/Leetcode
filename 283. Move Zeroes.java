public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length==0 || nums==null) {
           return; 
        }
        int ptrZ = 0;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0) {
               /*
                * ptrZ will not move
                * results in carrying the information 
                * of zeros.
                */
               continue;
            } else{
               if(ptrZ!=i){    
                 nums[ptrZ] = nums[i];
                 nums[i] = 0; 
               }
               ptrZ++;
            } 
            
        }
        
    }
}