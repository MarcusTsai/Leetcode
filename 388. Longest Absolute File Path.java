public class Solution {
    public int lengthLongestPath(String input) {
    //   if(input.length()==1) {
    //      return 0;  
    //   }
       
       String[] arr = input.split("\n");
       //Stack<Integer> stack = new Stack<>();
       ArrayDeque<Integer> stack = new ArrayDeque();
       
       // pseudo node if dir1, dir2, dir3..
       stack.push(0);
       int maxlen = 0;//Integer.MIN_VALUE;
       
       for(String s:arr) {
          // "+1"  if dir, return -1 for level0
          //       else,   return 0 for \t level 1    
          int level = s.lastIndexOf("\t") + 1; 
          
          // for sync current level at the stack
          while(level+1<stack.size()) stack.pop();

          // +1 for "/" 
          int len = stack.peek() + s.length()-level+1;
          //System.out.print(len);

          stack.push(len);
          //-1: no "/" in file
          if(s.contains(".")) maxlen = Math.max(maxlen, len-1);
       } 
       
       return maxlen; 
    }
}