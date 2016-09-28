public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) {
          return;    
        }
        if(m==0) {
          System.arraycopy(nums2, 0, nums1, 0, n); 
          return;
        } 
        
        int i=0, j=0;
        while(i<(m+j) && j<n) {
           if(nums1[i] > nums2[j]){
             System.arraycopy(nums1,i ,nums1, i+1, (m+j)-i);
             nums1[i] = nums2[j];
             j++;
           }
           i++;
        }
        if(j<n) {
          System.arraycopy(nums2, j, nums1, i, n-j);
        }      
    }

    // Concise solution: copy from the large values
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    if(n==0) {
      return;    
    }
    if(m==0) {
      System.arraycopy(nums2, 0, nums1, 0, n); 
      return;
    } 
    int i=m-1;
    int j=n-1;
    int k=m+n-1;
    
    while(i>=0 && j>=0) {
       if(nums1[i] >= nums2[j]) { 
         nums1[k--] = nums1[i--];     
       } else{
         nums1[k--] = nums2[j--];   
       }
    }
  
    if(j>=0) {
      System.arraycopy(nums2, 0, nums1, 0, j+1);     
    } 
             
    }
}