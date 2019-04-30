

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
        
        String ans = "[";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            
            TreeNode node = queue.poll();
            if (node != null){
                ans = ans + "," + node.val;
                queue.add(node.left);
                queue.add(node.right);
            } else{
                ans = ans + ",null";
            }    
        }
        return ans + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if (data == null || data == "[]"){
            return null;
        }
     
        // get the string between [, and ]
        String[] arr = data.substring(2, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);
        
        int i = 1;
        
        while (i < arr.length){
            
            TreeNode node = queue.poll();
            
            // On string, use equals() instead == 
            if (!arr[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(node.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(node.right);
            }
            i++;
                
        }
        
        return root;
    }
}
