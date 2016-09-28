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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
          return true;    
        }  
        int hL = height(root.left);
        int hR = height(root.right);
        if(Math.abs(hL-hR)>1) {
          return false;    
        } else{
          return isBalanced(root.left) && isBalanced(root.right);      
        }
        
        
    }
    private int height(TreeNode root) {
        if(root==null) {
          return 0;      
        }
        int hL = height(root.left);
        int hR = height(root.right);
        
        return 1+((hL>hR)?hL:hR);
    }

    //=====================================//
    // detect balance in the process of height calculation
    public boolean isBalanced(TreeNode root) {
        if(root==null){
          return true;    
        }  
        height(root);
        return balance;  
    }
    private int height(TreeNode root) {
        if(root==null) {
          return 0;      
        }
        int hL = height(root.left);
        int hR = height(root.right);
        if(Math.abs(hL-hR)>1) {
          balance = false;
        }
        return 1+Math.max(hL,hR);
    }

}