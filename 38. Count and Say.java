public class Solution {
    public String countAndSay(int n) {
        /* (i+1)th is ith sequence of count and play
         */
        if(n<=0) {
          return "-1";    
        } 
        
        String res = "1";
        if(n>1) {
          for(int i=2; i<=n; i++) {
             res = countAndsay(res);  
          }
        }
        return res;
    }
    private String countAndsay(String input) {
        StringBuilder res = new StringBuilder();
        int index = 0;
        System.out.println("input: " + input);
        System.out.println("len: " + input.length());

        // use two while loop to control index and count for character repetition
        while(index<input.length()){
           char anchor = input.charAt(index);
           int count = 0;
           while(index<input.length() && input.charAt(index)==anchor) {
              index++;
              count++;
           }
           res.append(String.valueOf(count)+anchor);
        }
        return res.toString();
    }
}