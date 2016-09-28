public class Solution {
    public int lengthOfLastWord(String s) {
      /* string null: no reference
       * string "": empty
       * string "\\s+" arbitarily white space
       */
      if(s==null || s.isEmpty() || s.matches("\\s+")) {
        return 0;  
      }   
      
      String[] sArray = s.split("\\s+");
      System.out.println(sArray.toString());
      return sArray[sArray.length-1].length();
    }
}