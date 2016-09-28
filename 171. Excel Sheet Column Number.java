public class Solution {
    public int titleToNumber(String s) {
        if (s.length() == 0 || s==null) {
           return -1;    
        }
        
        int result = 0;
        for (int i=s.length()-1; i>=0; i--) {
            // s[0] * 26^(length-1) + .. + s[length-1] * 26^(0) 
            result += (s.charAt(i)-'A'+1) * Math.pow(26, s.length()-1-i); 
        }
        return result;
    }
}