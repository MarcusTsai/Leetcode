public class Solution {
    public boolean isIsomorphic(String s, String t) {
        //if(s!=null && t!=null) {
           int[] sdic = new int[256];
           int[] tdic = new int[256];
           /* public V put(K key, V value)
            * The method call returns the previous value associated with key, 
            * or null if there was no mapping for key.
            * or use array and the index is stored to record last occurence 
            */
           for(int i=0; i<s.length(); i++) {

              if(sdic[s.charAt(i)] != tdic[t.charAt(i)] ){
                return false;
              }    
              sdic[s.charAt(i)] = i+1;
              tdic[t.charAt(i)] = i+1;
           }
           
    
        return true;
    }
}