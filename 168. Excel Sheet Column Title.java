public class Solution {
    public String convertToTitle(int n) {
      StringBuilder sb = new StringBuilder();
      
      while(n>0){
        /* watch out the mathematical relations
         */
        char ch = (char)((n-1)%26 + 65);
        System.out.println(ch);
        sb.append(""+ch);  
        n = (n-1)/26;
      }
      return sb.reverse().toString();
    }
}