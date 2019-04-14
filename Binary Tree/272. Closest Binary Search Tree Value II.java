/*

1. 
Time O(K + logN) 
Space Log(N): Tree Height
Time: if the tree is balanced, 
logN to find the closest node, K to traverse K elements

SAME THING as the K closest elements
Find the closest element then use two point to move up and down
but the implementation is tricky !!



2. 
Time O(N)
Space O(N)
In order traversal with a moving window
First add k elements to a linked list of size k
when it is full,
if (new Val - target) < (list.get(0) - target) 
list.add(new val)
list.remove(0)

*/

class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null || k <= 0){
            return ans;
        }

        TreeNode node = root;
        Stack<TreeNode> lowStack = new Stack<>();
        Stack<TreeNode> upStack = new Stack<>();

        // scan through a branch first
        // then use two stack to traverse up and down
        // only add nodes to the corresponding stack!!
        // Since later we only want to pop corresponding order of nodes
        
        
        // This loop does not stop at the end of one branch or at the height of tree
        // This loop stops at where there are no more "closer" nodes
        // That's how the BINARY SEARCH TREE is constructed
         
        while (node != null){
            if (node.val > target){
                upStack.push(node);
                node = node.left;
            } else {
                lowStack.push(node);
                node = node.right;
            }
        }
        
        // now use two pointer to traverse up and down
        // and add closer node on the way
        // be Aware of when the stack is empty
        for (int i = 0; i < k; i++){
            if (lowStack.isEmpty()){
                ans.add(upStack.peek().val);
                moveUp(upStack);
                continue;
            }
            if (upStack.isEmpty()){
                ans.add(lowStack.peek().val);
                moveLow(lowStack);
                continue;
            }
            if (Math.abs(target - lowStack.peek().val) < Math.abs(target - upStack.peek().val)){
                ans.add(lowStack.peek().val);
                moveLow(lowStack);
            } else {
                ans.add(upStack.peek().val);
                moveUp(upStack);
            }
        }
        
        return ans;
    }
    
    /* 
    MOVE UP -> IN ORDER TRAVERSE 
    LEFT ROOT RIGHT
    MOVE TO RIGHT -> FIND MOST LEFT NODE
    
    MOVE LOW -> MIRROR IN ORDER TRAVERSE
    RIGHT ROOT LEFT
    MOVE TO LEFT -> FIND MOST RIGHT NODE
    
    */
    private void moveUp(Stack<TreeNode> upStack){
        TreeNode node = upStack.pop();
        node = node.right;
        while (node != null){
            upStack.push(node);
            node = node.left;
        }
    }
    
    private void moveLow(Stack<TreeNode> lowStack){
        TreeNode node = lowStack.pop();
        node = node.left;
        while (node != null){
            lowStack.push(node);
            node = node.right;
        }
    }
