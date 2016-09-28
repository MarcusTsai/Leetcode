public class Solution {
    public String reverseString(String s) {
        //if(s!=null || s!=""){
        //StringBuilder sb = new StringBuilder();
        char[] s_arr = s.toCharArray();
        int i=0, j=s_arr.length-1;
        
        while(i<j) {
           char tmp = s_arr[i];
           s_arr[i] = s_arr[j];
           s_arr[j] = tmp;
           i++; j--;
        }
        return new String(s_arr);
        
        // for(int i=s.length()-1; i>=0; i--) {
        //   sb.append(s.charAt(i));    
        // }
        //return sb.toString();
        //}
        //return s;
    }
}