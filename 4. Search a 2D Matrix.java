public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
          return false;    
        }
        int targetRow = 0;
        int n = matrix[0].length;
        
        for(int i=0; i<matrix.length; i++) {
           if(target==matrix[i][0] || target==matrix[i][n-1]) {
             return true;    
           } else if(target>matrix[i][0] && target<matrix[i][n-1]) {
             targetRow = i;
             break;
           }    
        }
        
        return helper(matrix[targetRow], target, 0, n-1);
    }
    
    boolean helper(int[] array, int target, int left, int right) {
        if(left>right){
          return false;    
        }
        int mid = left + (right - left)/2;
        
        if(array[mid]==target) {
          return true;    
        }
        
        if(array[mid]<target){
          left = mid+1;
          return helper(array, target, mid+1, right);
        } else{
          return helper(array, target, left, mid-1);  
        }
        
    }
}