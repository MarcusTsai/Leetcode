public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root != null) {
           List<Integer> list = new ArrayList<>();
           helperFunc(root, result, list, sum);
        }
        
        return result;   
    }
    
    private void helperFunc (TreeNode node, List<List<Integer>> result, List<Integer> list, int sum) {
        if(node == null) {
          return;    
        }
        
        list.add(node.val);
        sum -= node.val;
        
        if (node.left == null && node.right == null) {
           if (sum == 0) {
              result.add(new ArrayList(list));
           }
        } 
        helperFunc(node.left, result, list, sum);
        helperFunc(node.right, result, list, sum);
        list.remove(list.size()-1);
    }
}