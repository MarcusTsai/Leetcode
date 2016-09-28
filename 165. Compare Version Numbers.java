public class Solution {
    public int compareVersion(String version1, String version2) {
        // can not directly switch to float
        // it can be 1.0.0.4, for example
        String[] l1 = version1.split("\\.");
        String[] l2 = version2.split("\\.");
        
        int len = Math.max(l1.length, l2.length);
        
        for(int i=0; i<len; i++) {
           Integer v1 = i<l1.length ? Integer.parseInt(l1[i]):0;
           Integer v2 = i<l2.length ? Integer.parseInt(l2[i]):0;
           
           int result = v1.compareTo(v2);
           if(result != 0) {
             return result;   
           } 
           
        }
        
        return 0;
    }
}