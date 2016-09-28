public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) {
          return 0;    
        }
        if(needle.length() > haystack.length()) {
          return -1;    
        }
        int len = needle.length();
        /* notice the equal condition since i is 
         * the starting character of the string needle in
         * the string haystack  
         */
        for(int i=0; i<=haystack.length()-len; i++) {
           if(haystack.substring(i, i+len).equals(needle)) {
             return i;
           }
        }
        return -1;
    }
}