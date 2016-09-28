public class Solution {
    /*
     * I: 1 V:5 X:10 L:50 C:100 D:500 M:1000
     * retrieve ruman from right character
     *  if val > anchor, add val
     *  else           , minus val
     */
    public int romanToInt(String s) {
       int result = 0;
       HashMap<Character, Integer> map = new HashMap<>();
       map.put('I', 1);
       map.put('V', 5);
       map.put('X', 10);
       map.put('L', 50);
       map.put('C', 100);
       map.put('D', 500);
       map.put('M', 1000);
       

       int anchor = map.get(s.charAt(s.length()-1));
       result += anchor;
 
       for (int i=s.length()-2; i>=0; i--) {
           int val = map.get(s.charAt(i));
           if (val>=anchor) {
              result += val;
           } else {
              result -= val;
           }
           anchor = val;
       }
  
       return result;
    }
}