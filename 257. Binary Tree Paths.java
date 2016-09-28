/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        
        if (root!=null) {
           StringBuilder st = new StringBuilder();
           helper(res, st, root);      
        }
        
        return res;
    }
    
    private void helper(List<String> res, StringBuilder st, TreeNode node) {
        if(node==null) {
            return;
        }
        
        int len = st.length();
        st.append(node.val+"->");
        
        if(node.left==null && node.right==null) {
          st.setLength(st.length()-2);
          res.add(st.toString());
        }
        //System.out.println("l: " + st.toString());
        helper(res, st, node.left);
        
        //System.out.println("r: " + st.toString());
        helper(res, st, node.right);

        /* back to  node of the parent, trim the string to the original
         * after parse the leaf child
         * note: it should parse to left and right child. And then back
         * to the parent node.
         */
        st.setLength(len);
                  
    }
}