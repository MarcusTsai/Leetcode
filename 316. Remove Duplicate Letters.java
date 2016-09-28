public class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] flag = new boolean [26];
        StringBuilder ns = new StringBuilder();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!flag[c-'a']) {
               flag[c-'a'] = true; 
               ns.append(c);
            }
        }
        
       char[] nsArray = ns.toString().toCharArray();
       Arrays.sort(nsArray);
       
       // char array to string
       return String.valueOf(nsArray);
        
    }
}