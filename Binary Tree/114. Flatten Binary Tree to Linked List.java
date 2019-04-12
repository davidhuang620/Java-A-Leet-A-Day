/*
The Key is draw the graph when we got confused
*/

// Iterative

class Solution {
    public void flatten(TreeNode root) {
        if (root == null){ return;}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                node.right = node.left;
                node.left = null;
                stack.push(node.right);
            }
            if (node.left == null && node.right == null){
                if (!stack.isEmpty()){
                    // TreeNode next = stack.pop();
                    // node.right = next;
                    // stack.push(next);
                    node.right = stack.peek();
                }
            }
        }
    }
}

// recursive
// 分
// 合
// 治


class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        if (root == null){ return null; }

        TreeNode leftLastNode = helper(root.left);
        TreeNode rightLastNode = helper(root.right);
        
        if (leftLastNode != null){
            // connect the last node of the left subtree and the first node in the right sub tree
            leftLastNode.right = root.right;
            //  swift the left subtree become the new right subtree
            root.right = root.left;
            // clean up the left pointer
            root.left = null;
        }

        if (rightLastNode != null){
            // if the old right subtree exist, its last node is the new last node
            // THE ORDER MATTERS, first check rightLast then leftLast
            return rightLastNode;
        }
        
        if (leftLastNode != null){
            // if the old right subtree does not exist, left last node is the new last node
            return leftLastNode;
        }
        
        //  if both does not exist, it is a leaf
        //  (root.left == null && root.right == null)

        return root;
    }
}
