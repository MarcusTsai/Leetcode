public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null) {
          return false;    
        }
        /* Utilize i,j to transverse the board
         * including row, col, & cube
         */
        for(int i=0; i<9; i++) {
           HashSet<Character> row = new HashSet<>();
           HashSet<Character> col = new HashSet<>();
           HashSet<Character> cube = new HashSet<>();
           for(int j=0; j<9; j++) {
              if(board[i][j]!='.' && !row.add(board[i][j])) {
                return false;  
              }
              if(board[j][i]!='.' && !col.add(board[j][i])) {
                return false;  
              }
              int index_x = 3*(int)(i/3) + j/3;
              int index_y = (i%3)*3 + j%3;
              if(board[index_x][index_y]!='.' && !cube.add(board[index_x][index_y])) {
                return false;  
              }
           }
        }
        return true;
    }  
}