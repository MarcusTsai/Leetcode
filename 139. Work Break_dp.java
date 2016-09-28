public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        
        boolean[] separable = new boolean [s.length()+1];
        
        separable[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=i; j>=0; j--) {
                String sub = s.substring(j, i);
                // if  0~j is separable && j~i is in the dictionary
                // word is separable
                if (wordDict.contains(sub) && separable[j]) {
                   separable[i] = true;
                   break;
                }
            }
        }
        return separable[s.length()];
    }
}