class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            int SUM = 0;
            TreeNode cur = root;
            TreeNode pre = null;

            while(cur!=null || !stack.isEmpty()){
                while(cur!=null){
                    stack.push(cur);
                    path.add(cur.val);
                    SUM+=cur.val;
                    cur=cur.left;
                }
                cur = stack.peek();
                
                /* if cur.right == pre stands that cur.right has been visited
                 * => do not direct to right, go to the root of the sub tree instead
                 * ** cur.right == pre means the two objects are the same not
                 * this statement does not equal cur.right.val == pre.val
                 */
                if(cur.right!=null && cur.right!=pre){
                    cur = cur.right;
                    continue;
                } 

                 
                if(cur.left==null && cur.right==null && SUM==sum) 
                    res.add(new ArrayList<Integer>(path));

                pre = cur;
                stack.pop();
                path.remove(path.size()-1);
                SUM-=cur.val;
                cur = null;

            }
            return res;
        }
}    