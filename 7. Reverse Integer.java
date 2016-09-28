public class Solution {
    public int reverse(int x) {
       // Check boundary and input should include the MIN_VALUE & MAX_VALUE
       // for the asymmetry
       if(x<=Integer.MIN_VALUE || x>=Integer.MAX_VALUE){
         return 0;  
       }       
       String s = String.valueOf(Math.abs(x));  
       System.out.println(Math.abs(x));
       StringBuilder rs = new StringBuilder();
       
       for(int i=s.length()-1; i>=0; i--) {
          rs.append(s.charAt(i)); 
       }
       
       long result = Long.parseLong(rs.toString());
       
       // Check boundary
       if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
         return 0;
       }
       
       if(x<0) {
         result = -result;  
       }
       
       return (int)result;  
    }
}