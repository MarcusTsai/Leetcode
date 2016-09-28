public class Solution {
   /* Stack
    */ 
    public String removeKdigits(String num, int k) {
        if(num.length()==0 || num==null) {
          return num;    
        }
        if(num.length()==k) {
          return "0";        
        }
        
        Stack<Character> stack = new Stack();
        
        for(int i=0; i<num.length(); i++) {
            //remove all the digits that are larger than current digits
            char c = num.charAt(i);
            while(!stack.empty() && stack.peek()>c && k>0) {
                stack.pop();
                k--;
                
            }
            if(i<num.length()-1 && c>num.charAt(i+1) && k>0) {
                k--;
            } else{
                stack.push(c);    
            }
        }
        
        for(int i = 0; i < k; i++) stack.pop();
        
        //remove heading zeros
        int index=0;
        while(index<stack.size() && stack.get(index++)=='0');
        
        StringBuilder sb = new StringBuilder();
        if(!stack.empty()) {
            for (index--; index < stack.size(); index++) {
                sb.append(stack.get(index));
            }
        }
        
        return sb.toString();
    } 
    
     /* ============================================ */
    public String removeKdigits(String num, int k) {
        if(k==0) return num;
        
        int strLen = num.length();
        int numDigits = strLen - k;
        char[] charArray = num.toCharArray();
        
        String res = "";
        int minIdx = 0, numLeft = numDigits;
        while(numLeft>0) {
           for(int i = minIdx+1; i<=strLen-numLeft; i++)
               if(charArray[i] < charArray[minIdx])  minIdx = i;
           
          if(strLen - minIdx == numLeft) {
              res = res + num.substring(minIdx);
              break;
          }
          
           numLeft--;
           res = res + charArray[minIdx];
           minIdx++;
        }

        //remove leading zeros
         char[] resCharArray = res.toCharArray();
         int start = 0;
         for(; start <resCharArray.length; start++)
             if(resCharArray[start] != '0') break; 
         
         res = res.substring(start);
         return (res.isEmpty())?"0":res;
    }
}