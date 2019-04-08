/*

Post Order 
left right root 

This is like the reverse of the pre order
Therefore we can use a LinkedList and add it reversely 

*/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        // putting it as linkedlist is the key
        LinkedList<Integer> ans = new LinkedList<>();
     
        if (root == null) return ans; 
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            // Reverse the order of the output
            // addFirst() !!!
            ans.addFirst(node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        
        return ans;
        
    } 
}
