/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "# ";

        }
        // string concation needs to use string builder
        StringBuilder data = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // BFS --> recursive?
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (cur == null) {
                    data.append("# ") ;
                } else {
                    data.append(cur.val + " ") ;
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }

        return data.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] dataArray = data.split(" ");
        if (dataArray[0].equals("#")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        for (int i = 1; i < dataArray.length; i+= 2) {
            TreeNode parent = queue.remove();
            //System.out.println("i: " + i);
            String symbol = dataArray[i];
            if (!symbol.equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(symbol));
                parent.left = left;
                queue.add(left);
            } 
            /* there is no error for index since we use "#" for null node
             */
            symbol = dataArray[i+1];
            if (!symbol.equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(symbol));
                parent.right = right;
                queue.add(right);
            }
            
            
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));