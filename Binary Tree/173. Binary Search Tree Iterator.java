
/**
a more length solution 
 */
 
class BSTIterator {

    private Stack<TreeNode> stack;
    private TreeNode nodePt;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        nodePt = root;
        findLeftest();
    }
    
    /** @return the next smallest number */
    public int next() {
        nodePt = stack.pop();
        int res = nodePt.val;
        if (nodePt.right != null){
            nodePt = nodePt.right;
            findLeftest();
        }
        return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void findLeftest(){
        while (nodePt != null){
            stack.push(nodePt);
            nodePt = nodePt.left;
        }
    }
    
}

/*
Shorter code 
Since thee node pointer is pass in different functions,
the pointer in the local scope will always point to the same node
we don't need another node pointer 
*/

class BSTIterator {

    private Stack<TreeNode> stack; 

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        findLeft(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        // the node will still point to the same node after findLeft()
        findLeft(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void findLeft(TreeNode node){
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
