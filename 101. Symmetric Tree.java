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
    // Iterative
       public boolean isSymmetric(TreeNode root) {
           if(root == null) {
             return true; 
           }
          // ArrayDeque cannot store null element but linkedList can 
          Queue<TreeNode> queue1 = new LinkedList<>();
          Queue<TreeNode> queue2 = new LinkedList<>();
          
            
         queue1.add(root.left);
         queue2.add(root.right);
      
          
          while(!queue1.isEmpty() && !queue2.isEmpty()) {
              if(queue2.size() !=  queue1.size()) {
                 return false;  
              }
               
                  for (int i=0; i<queue1.size(); i++) {
                  TreeNode currPtr1 = queue1.remove();
                  TreeNode currPtr2 = queue2.remove();
                   
        
                  if(currPtr1==null && currPtr2==null) {
                     continue;  
                  } 
                   
                  if(currPtr1 == null || currPtr2 == null) {
                     return false;  
                  }
                   
                  if(currPtr1.val != currPtr2.val) {
                      return false;  
                  }
                   
                  queue1.add(currPtr1.left);
                  queue1.add(currPtr1.right);

                  // Reverse direction
                  queue2.add(currPtr2.right);
                  queue2.add(currPtr2.left);
              }
          }
          return true;
           
       }
    
    
    
    Recursive
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
          return true;    
        }    
        
        return isCompare(root.left, root.right);
        
    }
    
    boolean isCompare(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
          return true;    
        } else if(node1 == null || node2 == null){
          return false;    
        } else if(node1.val != node2.val) {
          return false;    
        }
        return isSymmetry(node1.left, node2.right) && isSymmetry(node1.right, node2.left);
    }
  
}