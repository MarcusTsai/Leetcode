public class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0) {
          return s;    
        }
        // remove the whitespace in the head and the tail
        s = s.trim();
        String[] strArray = s.split("\\s+");
        int i = 0;
        int j = strArray.length-1;
        
        while(i<j) {
           String tmp = strArray[j];    
           strArray[j] = strArray[i];
           strArray[i] = tmp;
           i++; j--;
        }
        StringBuilder sb = new StringBuilder();
        
        for(int k=0; k<strArray.length; k++) {
           sb.append(strArray[k]);  
           if(k != strArray.length-1) {
               System.out.println("last");
               sb.append(" ");  
           }
        }
        
   
        
        return sb.toString();
    }
}