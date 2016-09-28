public class WordSearch {
    public boolean exist(char[][] board, String word) {

        char[] wordArray = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];

        // Transverse each entry

        for(int y=0; y<board.length; y++) {
           for(int x=0; x<board[0].length;x++) {
                if(helper(board, visited, 0, 0, wordArray, 0)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean helper(char[][] board, boolean[][] visited, int y, int x, char[] word, int i) {
        if(i==word.length) {
            return true;
        }
        if(x<0||y<0||y==board.length||x==board[0].length) {
            return false;
        }
        if(word[i]!=board[y][x] || visited[y][x]) {
            return false;
        }
        // Mark the given letter has been visited
        visited[y][x] = true;
        //board[y][x] ^= 128; can directly mark on the table

        System.out.println("y, x, i: " + y + " " + x + " " + i);
        print2d(visited);

        boolean exist = helper(board, visited, y, x-1, word, i+1) ||
                helper(board, visited, y, x+1, word, i+1) ||
                helper(board, visited, y-1, x, word, i+1) ||
                helper(board, visited, y+1, x, word, i+1);
        
        // reference, need to be restored
        visited[y][x] = false;
        //board[y][x] ^= 128;

        return exist;
    }

    private void print2d(boolean[][] board) {
       for(int i=0; i<board.length; i++) {
          System.out.println(Arrays.toString(board[i]));
       }

    }

    public static void main(String[] args) {
        WordSearch test = new WordSearch();
        char[][] board = {{'a', 'b'} ,{'b', 'c'}};
        String word = "abf";

        System.out.println(test.exist(board, word));
    }
}