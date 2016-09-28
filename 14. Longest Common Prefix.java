public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) {
         return "";    
        }
        String prefix = strs[0];
        
        for(int i=1; i<strs.length; i++) {
           /*int indexOf(String str): 
            * Returns the index within this string of the first occurrence of the specified substring. 
            * If it does not occur as a substring, -1 is returned
            * iteratively reduce the prefix until it matches
            */
           while(strs[i].indexOf(prefix)!=0) {
              prefix = prefix.substring(0, prefix.length()-1); 
           }
        }
        return prefix;
    }
    
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) {
         return "";    
        }
        
        for(int i=0; i<strs.length; i++) {
           // if using object, utilize equals instead of == for comparison    
           if(strs[i].equals(""))
             return "";
        }
        
        char[] res = strs[0].toCharArray();
        int m = res.length;
        if(strs.length > 1){
         for(int k=1; k<strs.length; k++) {
            int i = 0;
            int j = 0;
            if( m > strs[k].length()) m = strs[k].length();
            
            while(i<m) {
               if(res[i]!=strs[k].charAt(j)) {
                 m = i;
                 break;  
               }
               i++;
               j++;
            }
          }
        }
        //if(m==0) return "";
        System.out.println(new String(res, 0, 1));
        return new String(res, 0, m);
    }
}