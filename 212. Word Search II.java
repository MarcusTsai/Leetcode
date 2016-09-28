/* Basic solultion
 * ==> Use HashSet, Trie, DFS 
 * 1. HashSet: in case of any duplicated words existing in the query
 * 2. Trie: use to build the dictionary of the quary 
 * 3. DFS : chess board transversal
 */ 
public class Solution {
	Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }


        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[0].length; x++) {

                dfs(board, new StringBuilder(), x, y, trie);
            }
        }

        return new ArrayList<String>(res);
    }

    private void dfs(char[][] board, StringBuilder str, int x, int y, Trie trie) {
        // if (x<0 || y<0 || x==board[0].length || y==board.length) {
        //     return;
        // }

        if((int)board[y][x]>122) {
            //System.out.println("Visited!");
            return;
        }

        //System.out.println("New Char: " + board[y][x] + " " + (int)board[y][x]);
        str.append(board[y][x]);
        //System.out.println("Cummulated String: " + str);

        if (!trie.startsWith(str.toString())) {
            //System.out.println("No match, return!");
            str.setLength(str.length() - 1);
            return;
        }

        if (trie.search(str.toString())) {
            res.add(str.toString());
        }

        //System.out.println("board(marked before): " + (int)board[y][x]);
        board[y][x]^=255;
        //System.out.println("board(marked after): " + (int)board[y][x]);
        
        /* Check the boundary of the anchor
         *
         */
        if(x>0)                 dfs(board, str, x-1, y, trie);
        if(x<board[0].length-1) dfs(board, str, x+1, y, trie);
        if(y>0)                 dfs(board, str, x, y-1, trie);
        if(y<board.length-1)    dfs(board, str, x, y+1, trie);

        /* Recover to the previous states
         * Note: Since string is the use of duplication,
         * it is unnecessary to recover. However, there is only one StingBuilder,
         * it should be restore to the previous status.
         */
        str.setLength(str.length() - 1);
        board[y][x]^=255;
    }
    
    
	class TrieNode {
	    public TrieNode[] child = new TrieNode[26];    
	    public boolean isLeaf ;
	}

	class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	   // Inserts a word into the trie.
	    public void insert(String word) {
	        TrieNode ptr = root;
	        for(char c: word.toCharArray()) {
	           int index = c-'a';
	            if (ptr.child[index] == null) {
	               ptr.child[index] = new TrieNode(); 
	            }
	            ptr = ptr.child[index];
	        }
	        ptr.isLeaf = true;  
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	       TrieNode ptr = helper(word);
	       return ptr!=null && ptr.isLeaf==true;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	       return helper(prefix)!=null;     
	    }
	    
	    private TrieNode helper(String prefix) {
	       TrieNode ptr = root;
	       for(char c: prefix.toCharArray()) {
	           int index = c-'a';
	           
	           /* The math operation of characters 
                * can be transferred in to integer.
                * => can be utilized as index
                */
	           if (ptr.child[index]==null) {
	              return null; 
	           }
	           ptr = ptr.child[index]; 
	       }
	       return ptr;
	    }
	}
}

public class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
	    List<String> res = new ArrayList<>();
	    
	    /* Do not need hastset to check duplication 
	     * if there is a duplicated string, the path would be just revisited
         */
	    TrieNode root = buildTrie(words);
	    
	    for(int y = 0; y < board.length; y++) {
	        for(int x = 0; x < board[0].length; x++) {
	            dfs(board, x, y, root, res);
	        }
	    }
	    return res;
    }
    
    /* Use Trie node for transveal instead of using search and start with
     *  the content of Trie should be further utilized
     */
    public void dfs(char[][] board, int x, int y, TrieNode trie, List<String> res) {
    	char c = board[y][x];
        
    	if(c > 127 || trie.next[c-'a']==null) {
          return;
    	}
    	trie = trie.next[c-'a'];

    	// if the node contains a end of a string, add the string to the list
        
        if(trie.word!=null) {
          res.add(trie.word);
          trie.word = null;
        }
        board[y][x]^= 255;

        if(x>0)                 dfs(board, x-1, y, trie, res);
        if(x<board[0].length-1) dfs(board, x+1, y, trie, res);
        if(y>0)                 dfs(board, x, y-1, trie, res);
        if(y<board.length-1)    dfs(board, x, y+1, trie, res);

        board[y][x]^= 255;
   
    } 



    /* Check the string within each node rather than 
     *  use build-in start with and search path
     */
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    public TrieNode buildTrie(String[] words) {
       TrieNode root = new TrieNode();
       
       for(String w: words) {
       	  TrieNode trie = root;
          for(char c: w.toCharArray()) {
             int i = c - 'a';
             if(trie.next[i]==null) 
             	{trie.next[i] = new TrieNode();
             }
             trie = trie.next[i];
       	  }
          trie.word = w;
       }
       return root;
    }  

}
