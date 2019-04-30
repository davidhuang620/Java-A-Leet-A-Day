/*
Ues int to reperent the state: if the node is found or not

*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){ 
            return root; 
        }
        List<TreeNode> ans = new ArrayList<>();
        helper(root, p, q, ans);
        return ans.get(0); 
    }
    
    private int helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> ans){
        if (root ==null){
            return 0;
        }
        int state = 0;
        if (root == p || root == q){
            state++;
        }
        int leftState = helper(root.left, p, q, ans);
        int rightState = helper(root.right, p, q, ans);
        if (leftState + rightState + state == 2){
            ans.add(root);
            return 3;
        }
        return leftState + rightState + state;
    }
    
}


/*
Shorter solution
Only viable when a node p and q are guaranteed to be found in the tree

Cases:
1. One node at left subtree, one node at right subtree, return root
2. Found one node return the node, we don't need to continue to search, 
    becuase in all cases return node will work:
    a. the other node is in subtree of the found node, we should return the node
    b. the other node is not in the subtree of the found node, then we will meet the other node later somewhere
3. if no node is found, return null
*/


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){ return null; }
        if (root == p || root == q){ return root; }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){ return root;}
        if (left != null){ return left;}
        if (right != null){ return right;}
        return null;
    }
}



