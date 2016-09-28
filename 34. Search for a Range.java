public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int head = -1;
        int tail = -1;
        for(int i=0; i<nums.length; i++){
           if(nums[i]==target){
             if(head==-1) {
               head = i;     
             } else{
               tail = i;     
             }  
           }    
        }
        
        if(tail==-1) {
          tail = head;        
        } 
        return new int[]{head, tail};    
    }
}