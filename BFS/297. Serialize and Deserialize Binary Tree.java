

/*
IN A BFS WAY (It's not the optimized way!)

Some Functions:
String.substring(startIndex, endIndex) (inclusive, exclusive)
String.split(",")
Int someInt = Integer.parseInt(someString)
String comparison: use String.equals() instead of == 
*/


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    
        if (root == null){
            return null;
        }
        
        String ans = "[" + root.val;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int pt = 0;
        
        while (pt < queue.size()){
            
            TreeNode node = queue.get(pt);
            if (node.left == null){
                ans = ans + ",null";
            } else {
                ans = ans + "," + node.left.val;
                queue.add(node.left);
            }
            if (node.right == null){
                ans = ans + ",null";
            } else {
                ans = ans + "," + node.right.val;
                queue.add(node.right);
            }
            pt++;
        }
        
        return ans + "]";
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if (data == null || data == "[]"){
            return null;
        }
        
        String[] arr = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);
        boolean left = true;
        int index = 0;
        
        for(int i = 1; i < arr.length; i++){
            
            // On string, use equals() instead == 
            if (!arr[i].equals("null")){
                TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
                if (left){
                    queue.get(index).left = node;
                    queue.add(node);
                } else {
                    queue.get(index).right = node;
                    queue.add(node);
                }
            }
            // important
            // Each node have two children we only index++ after the right node
            if (!left){
                index++;
            }
            left = !left;
        }
        
        return root;
    }
}
