public class Solution {
    public boolean exist(char[][] board, String word) {
        
        char[] wordArray = word.toCharArray();
        //boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int y=0; y<board.length; y++) {
           for(int x=0; x<board[y].length; x++) {
              if(helper(board, y, x, 0, wordArray)) {
                return true;  
              } 
           }    
        }
        
        return false;
    }
    
    boolean helper(char[][] board, int y, int x, int len, char[] wordArray) {
        if(len==wordArray.length) {
          return true;        
        }
        if(x<0||y<0||y==board.length||x==board[y].length) {
          return false;    
        }
        
        if(board[y][x]!=wordArray[len]) {
          return false;    
        }  
        //visited[y][x] = true;
        // after xor with 255, the outcome is over 127 ==> display with blank
        board[y][x]^=256; 
        
        boolean up = false, down = false, left = false, right = false;
        
        //System.out.println("len" + len);
        // if one of the four conditions is set, the others will jump out
        // --> reduce time consumption
        boolean existed = helper(board, y, x-1, len+1, wordArray) ||
                          helper(board, y, x+1, len+1, wordArray) || 
                          helper(board, y-1, x, len+1, wordArray) || 
                          helper(board, y+1, x, len+1, wordArray);
       
        
        
        //visited[y][x] = false;
        
        board[y][x]^=256; 
        
        return existed;
    }
}