
/**

分 Divide    recursion to left and right, (1 node -> 2 nodes)
治 Conquer   Operation 
            (Before Merge, dealing with one node of things)
             sometimes recursion could be a void function
             since we don't have anymore operation after merge 
合 Merge     return and traverse the second time (2 nodes-> 1 node)

*********

分 Divide    recursion to left and right, (1 node -> 2 nodes)
合 Merge     return and traverse the second time (2 nodes-> 1 node)
治 Conquer   Operation 
            (After Merge, dealing with two nodes of things)
            sometime infos from two nodes is necesarry, ex: sum, min, max
            Be careful of what kind of ds and return value 
            to store more than one info
*********     

Think clearly of what parameter/ data structure we need to pass in to the next recursion. 

Draw a graph if we got confused.


 */



/*
分
治
合
*/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> ans = new ArrayList<String>();
        helper(root, "", ans);
        return ans;
    }
    
    private void helper(TreeNode root, String path, List<String>ans){
    
        if (root == null){
            return;
        }
        path = path + root.val + "->";
        helper(root.left, path, ans);
        helper(root.right, path, ans);
        // until both left and right node is null, then we reach a leaf
        if (root.left == null && root.right == null){
            path = path.substring(0, path.length() - 2);
            ans.add(path);
            return;
        }
    }
}


/*
分 
合
治
*/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        return helper(root);
    }
    
    private List<String> helper(TreeNode root){
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        // only when both left and right is null, it is a leaf
        // then we can return this as a path
        if (root.left == null && root.right == null){
            res.add("" + root.val);
            return res;
        }
        // for every path in the left subtree, we need to add root.val 
        if (root.left != null){
            List<String> lList= helper(root.left);
            for (String path : lList){
                path = root.val + "->" + path;
                res.add(path);
            }
        }
        // for every path in the right subtree, we need to add root.val 
        if (root.right != null){
            List<String> rList= helper(root.right);
            for (String path : rList){
                path = root.val + "->" + path;
                res.add(path);
            }            
        }
        return res;
    }
}

/*
ITERATIVE
NEED a path stack

*/

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        // We need a path stack
        // because every path at every node in the stack is different
        // while adding the node to the node stack
        // Also adding the correspond path to the path stack
        // so we can get the correct path for each node when we pop the path stack
        Stack<String> pathStack = new Stack<>();
        String path = "";
        pathStack.push(path);

        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            path = pathStack.pop();
            path = path + node.val + "->";
            // leaf reached
            if (node.left == null && node.right == null){
                path = path.substring(0, path.length() - 2);
                ans.add(path);   
            }
            
            // while adding the node to the node stack
            // Also adding the correspond path to the path stack
            if (node.right != null){
                nodeStack.add(node.right);
                pathStack.add(path);
            }
            if (node.left != null){
                nodeStack.add(node.left);
                pathStack.add(path);
            }
            
        }
        return ans;
    }
}
