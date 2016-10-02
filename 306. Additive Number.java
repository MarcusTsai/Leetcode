/*  Integer.valueOf() --> return an Integer object (wrap the int to Integer)
 *  Integer.parseInt(String) --> return the primitive integer within the string
 */

public boolean isAdditiveNumber(String num) {
   if(num==null || num.length()<3) {
       return false;
   }
   int n = num.length();
   boolean res = false;
   
   // Leave origin option in main function 
   for(int alen=1; alen<=n-2; alen++) {
      for(int blen=1; alen+blen<=n-1; blen++){
         if(alen!=1 && num.substring(0, 1).equals("0")) continue;
         if(blen!=1 && num.substring(alen, alen+1).equals("0")) continue;
         Long a = Long.parseLong(num.substring(0, alen));
         Long b = Long.parseLong(num.substring(alen, alen+blen));
         
         res = check(a, b, num, alen+blen); 
         if(res==true) return true;
      }    
   }
   return false;
}
/* Isolate the whole additive process (to the end of the string) into a function 
 */
private boolean check(Long a, Long b, String num, int start) {
   int n = num.length();
   
   while(start<n) {
     Long c=a+b;
     String str = Long.toString(c);
     for(int clen=1; clen<=n-start; clen++) {
        if(num.substring(start, start+clen).equals(str)) {
          if(clen==n-start) return true;    
          else{ 
            start+=clen;
            break;
          }
        }
        if(clen==n-start) return false;
     }
     a = b;
     b = c;
   }
   
   return false;
} 