/*

In order 
Left Root Right

At a high level thinking, imagine we are creating a stack of the left main branch
when we encounter the left most grand child, we record it and start poping
while poping every node, we record it and we need to check the right node of every node
while checking the right node of every node, we repeat the whole process of finding the left most grand child
Therefore, we traverse left -> Root -> Right

Very Creative Solution
1. Finding the left most Grand Child
2. Adding every parent nodes (root of every sub tree) to the Stack on the way 
3. When we found it, record it and pop the stack 
4. when we pop the stack we are back to the parent node (root of the sub tree)
5. Record it 
6. move on to the right node of the parent node
7. But the right node may be the root of another sub tree 
   Since it is in order, we need to find the left most before we record the root.
8. Repeat the whole process from step 1

*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        if (root == null){
            return ans;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        // node != null  => so that we can enter the loop with an empty stack
        // Because we will add the root in the stack later on
        
        while (node != null || !stack.isEmpty()){
            // 1. Find the left most grand child
            while (node != null){
                // 2. push parent to the stack on the way
                stack.push(node);
                node = node.left;
            }
            // when we jump out of the loop, node == null
            node = stack.pop();
            // Do whatever operation here
            ans.add(node.val);
            // search for the left most child on the right node again
            node = node.right;
        }

        return ans;
    }
    

}
