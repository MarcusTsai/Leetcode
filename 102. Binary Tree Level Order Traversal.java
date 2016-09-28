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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root!=null) {
          helper(0, result, root);
        }
        return result;        
    }
    
    private void helper(int level, List<List<Integer>> result,TreeNode node) {
        if(node==null) {
          return;    
        }  
        
        // note: addAll is used to sum two lists
        if(result.size()<level+1) {
          /* It should put the lowest level(leafs)
           * val in the lowest index
           */
          result.add(level, new ArrayList<Integer>());
          result.get(level).add(node.val);
        } else{
          result.get(level).add(node.val);
        }
        /* Cannot use ++level, since it will affect level
         * for next helper function
         */
        helper(level+1, result, node.left);
        helper(level+1, result, node.right);
    }    
}