public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
       int left = Math.max(A, E);
       int right = Math.min(C, G);
       
       int down = Math.max(B, F);
       int top = Math.min(D, H);
       
       //overlap conditions
       int overlap = 0;
       if(right>left && top>down) {
         overlap = (right-left) * (top-down);  
       }
       
       int rect1 = (C-A) * (D-B);
       int rect2 = (G-E) * (H-F);
            
       return rect1 + rect2 - overlap;   
    }
}