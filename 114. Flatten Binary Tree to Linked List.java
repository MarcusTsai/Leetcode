public class FlatTree {
    private TreeNode prev = null;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

     public void flatten(TreeNode root) {
        if(root!=null){
            helper(root, null);
        }
    }

    private TreeNode helper(TreeNode node, TreeNode prev) {
        if(node==null) {
          // pass the prev node the upper layer
          return prev;
        }

        prev = helper(node.right, prev);
        // pass the right node to the left one
        prev = helper(node.left, prev);

        System.out.println("node: " + node.val);
        if(prev!=null) {
            System.out.println("prev: " + prev.val);
        } else{
            System.out.println("prev: null");
        }
        node.left = null;
        node.right = prev;
        

        return node;

    }

    public void flatten(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
           TreeNode cur = stack.pop();
           System.out.println(cur.val);
           if(cur.right!=null) {
               stack.add(cur.right);
           }

           if(cur.left!=null) {
             stack.add(cur.left);
           }

           if(!stack.isEmpty()) {
               cur.right = stack.peek();
           }
           cur.left = null;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        FlatTree test = new FlatTree();
        test.flatten(root);
    }

}