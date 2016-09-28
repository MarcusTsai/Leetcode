public class Solution {
    public int countPrimes(int n) {
        if(n<2) {
          return 0;        
        }
        //List<Integer> primes = new ArrayList<>();
        //primes.add(2);
        int count = 0;
        
        if(n>2){
         boolean[] noPrime = new boolean[n];   
         for(int i=2; i<n; i++) {
            if(noPrime[i]==false) {
              count++;    
              /* set all the numbers that can be divided by i to true
               * so that such number can be skipped
               */
              for(int j=2; i*j<n; j++) {
                 noPrime[i*j] = true; 
              }
            } 
         }
        }
        
        return count;
    }
    public int countPrimes(int n) {
        if(n<2) {
          return 0;        
        }
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        
        if(n >2){
         for(int i=3; i<n; i++){
            int factor = primes.get(0);
            boolean find = false;
            int k=1;
            // some numbers are recalculated
            while(factor<i/2){

              if(i%factor==0){
                find = true;
                break;
              }
              k++;
              factor = primes.get(k); 
            }
            
            if(find==false) {
              primes.add(i);
            }
         }
        }
        
        return primes.size();
    }
}