class TrieNode {
   /* Initialize your data structure here.
    * Declare Array Type
    * This structure contains 26 pointers as well as indicators
    * to record if this is a leaf node
    */
   public TrieNode[] child = new TrieNode[26];  

   // Use the end character of the string
   public boolean isLeaf ;
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode ptr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (ptr.child[c-'a'] == null) {
               ptr.child[c-'a'] = new TrieNode(); 
            }
            ptr = ptr.child[c-'a'];
        }
        ptr.isLeaf = true;
        //System.out.println("insert " + ptr.isLeaf);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode ptr = helper(word);
       return ptr!=null && ptr.isLeaf==true;
    }

    /* Returns if there is any word in the trie
     * that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
       return helper(prefix)!=null;     
    }
    
    /* The common function of search and startsWith
     */ 
    private TrieNode helper(String prefix) {
       TrieNode ptr = root;
       for (int i=0; i<prefix.length(); i++) {
           char c = prefix.charAt(i);
           if (ptr.child[c-'a']==null) {
              return null; 
           }
           ptr = ptr.child[c-'a']; 
       }
       return ptr;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");