public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        
        if(a!=null && b!=null) {
          int i = a.length()-1;
          int j = b.length()-1;
          int carry = 0;
          
          while(i>=0 || j>=0 || carry!=0) {
             // notice the carry in & getNumericValue funcrion
             int val1 = (i==-1) ? 0:Character.getNumericValue(a.charAt(i));
             int val2 = (j==-1) ? 0:Character.getNumericValue(b.charAt(j));
             
             int sum = val1 ^ val2 ^ carry;
             carry = (val1+val2+carry)>=2 ? 1:0 ;
             res.append(String.valueOf(sum));
             
             if(i>=0) i--;
             if(j>=0) j--;
          }
          
        }
        return res.reverse().toString();
    }
}