/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* For binary search tree
 * step1. 
 *        <--left--> root <--right-->
 * in order : 10, 30, 40, 50, 60, 70, 90
 *             <--left--> <--right--> root
 * post order: 10, 40, 30, 60, 90, 70, 50
 *
 * step2.    left root right
 * in order : 10, 30, 40
 *            left right root
 * post order: 10,  40,  30
 * 
 * go on to the same step as the range of index is invalid
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0) {
          return null;        
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // put inorder location
        for(int i=0; i<inorder.length; i++) {
           map.put(inorder[i], i);       
        }
        
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    
    private TreeNode helper(int[] inorder, int in_s, int in_e, int[] postorder, int ps_s, int ps_end,  HashMap<Integer, Integer> map) {
        
        if(in_s>in_e || ps_s>ps_end) {
          return null;        
        }    
        
        TreeNode node = new TreeNode(postorder[ps_end]);
        int anchor = map.get(node.val);
        
        TreeNode left = helper(inorder, in_s, anchor-1, postorder, ps_s, ps_s+anchor-in_s-1, map);
        TreeNode right = helper(inorder, anchor+1, in_e, postorder, ps_s+anchor-in_s, ps_end-1,map);
        
        node.left = left;
        node.right = right;
        return node;
    }
    
}