public class Solution {


    public String convert(String s, int numRows) {
       char[] charArray = s.toCharArray();
       int len = charArray.length;
       StringBuilder[] sb = new StringBuilder[numRows];
       
       for(int i=0; i<numRows; i++) {
          sb[i] = new StringBuilder(); 
       }
       
       int i = 0;
       while(i<len) {
         int idx=0;  
         // veritcally down
         for(; idx<numRows && i<len; idx++) {
            sb[idx].append(charArray[i++]); 
         }  
         // opliquely up
         for(idx-=2; idx>=1 && i<len; idx--) {
            sb[idx].append(charArray[i++]); 
         }
       }
       
       for(int j=1; j<numRows; j++) {
          sb[0].append(sb[j].toString()); 
       }
       return sb[0].toString();
    }

    public String convert(String s, int numRows) {
        if ( s.length() == 0 || s.length() == 1 || numRows == 0 || numRows == 1) {
           return s;
        }
        if (s.length() <= numRows) {
           return s;    
        }
        
        int size = 2*numRows - 2;
        System.out.println("size " + size);
        
        StringBuilder newstring = new StringBuilder();
        
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows-1) {
               for (int j = i; j < s.length(); j+= size) {
                   newstring.append(s.charAt(j));
               }   
            } else {
               boolean nextOdd = true; 
               int j = i;
               while (j < s.length()) {
                 newstring.append(s.charAt(j));
                 if (nextOdd) {
                    j += size - 2*i; 
                    nextOdd = false;
                 } else{
                    j += 2*i;
                    nextOdd = true;
                 }
               }    
                                
            }
        }
 
        return newstring.toString();
    }
}