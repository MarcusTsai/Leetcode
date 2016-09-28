public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      
       // use set to avoid duplicated element
       Set<Integer> list = new HashSet<>();
       
       Arrays.sort(nums1);
       Arrays.sort(nums2);
       int i=0, j=0;
       
       while(i<nums1.length && j<nums2.length) {
           if(nums1[i]<nums2[j]) {
             i++;  
           } else if(nums1[i]>nums2[j]) {
             j++;  
           } else {
             list.add(nums1[i]);
             i++; j++;
           }
       } 
       //System.out.println(list.size());
       
       int[] result = new int[list.size()];
       
       if(list.size() != 0) {
         int k=0;  
         for(Integer element:list) {
            result[k++] = element; 
         }    
       }
       
       return result;
    }   
}