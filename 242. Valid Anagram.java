public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
          return false;  
        }
        
        int[] flag = new int[26];
        
        for (int i=0; i<s.length(); i++) {
            flag[s.charAt(i)-'a']++;    
        }
        
        for (int i=0; i<t.length(); i++) {
            flag[t.charAt(i)-'a']--;    
        }
        
        for (int i=0; i<26; i++) {
            if(flag[i]!=0){
              return false;    
            }
        }
        return true;
    }
}