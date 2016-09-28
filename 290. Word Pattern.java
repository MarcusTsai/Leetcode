public class Solution {
    
    public boolean wordPattern(String pattern, String str) {
        if(pattern!=null && str!=null){
          String[] strarray = str.split("\\s+");
          //System.out.println("s: " + strarray.length);
          //System.out.println("p: " + pattern.length());
          if(strarray.length != pattern.length()) {
            return false;  
          }
          // Key can be character as well as any type
          Map dict = new HashMap();
          
          // Record the index of the first occurence
          for(Integer i=0; i<strarray.length; i++) {
             if(dict.put(strarray[i], i) != dict.put(pattern.charAt(i), i)) {
               return false;     
             } 
          }
            
        }
        return true;
    }

    public boolean wordPattern(String pattern, String str) {
        if(pattern!=null && str!=null){
          Map<Character, Integer> pdict = new HashMap<>();    
          int[] pcount = new int[26];
          Integer index = 0;
          for(int i=0; i<pattern.length(); i++) {
             if(!pdict.containsKey(pattern.charAt(i))) {
               pdict.put(pattern.charAt(i), index);  
               pcount[index]++;
               index++;
             }else{
               pcount[pdict.get(pattern.charAt(i))]++;     
             } 
          }
          
          String[] strarr = str.split("\\s+");
          Map<String, Integer> dict = new HashMap<>();
          index = 0;
          
          for(int i=0; i<strarr.length; i++){
             if(!dict.containsKey(strarr[i])) {
               pcount[index]--;
               dict.put(strarr[i], index);
               index++;
             }else{
               int wvalue = dict.get(strarr[i]); 
               pcount[wvalue]--;
             }  
          }
          for(int i=0; i<26; i++){
             if(pcount[i]!=0) {
               return false;     
             } 
          }
        }
        return true;
    }
}