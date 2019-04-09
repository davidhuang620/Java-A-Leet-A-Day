/*
There are three ways of solving this problem.
SHOULD PRACTICE ALL OF THEM

*/

/* 
1. IN ORDER
Left -> Node -> Right order of inorder traversal means for BST that each element should be smaller than the next one.
*/
class Solution {
    private boolean valid;
    private TreeNode lastNode;
    public boolean isValidBST(TreeNode root) {
        valid = true;
        lastNode = null;
        inorder(root);
        return valid;
    }
    // We are comparing last node to the current node, 
    // but the current node is not neccessarily the parent of the last node
    // could be a root far away
    // so we need a class variable to keep track of the last node
    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        if (lastNode != null && lastNode.val >= root.val){
            valid = false;
            return;
        }
        lastNode = root;
        inorder(root.right);
    }
}
