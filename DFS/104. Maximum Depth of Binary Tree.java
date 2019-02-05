
// Tree Traversal 


// Optimal

// Recursion

/* Keys
1. variable counter could just be passed in the return statement.
2. Recursion can happens in just one function.
*/

class Solution {
  public int maxDepth(TreeNode root){
    if(root == null){return 0;}
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}


// Iteration DFS

/* Keys
1. edge cases: when input root node is empty
2. Stack <type> variable = new Stack <>();
3. Stack <Integer>
*/

class Solution {
  public int maxDepth(TreeNode root){
   
    if(root == null){
        return 0;        
    }
      
    Stack<TreeNode> nodeStack = new Stack<>();
    Stack<Integer> depthStack = new Stack<>();
    int maxDepth = 0;

    nodeStack.push(root);
    depthStack.push(1);
    
    while(!nodeStack.isEmpty()){
        TreeNode node = nodeStack.pop();
        int depth = depthStack.pop();
      
        maxDepth = Math.max(maxDepth,depth);
        
        if(node.right != null){
          nodeStack.push(node.right);
          depthStack.push(depth+1);
        }
        
        if(node.left != null){
          nodeStack.push(node.left);
          depthStack.push(depth+1);
        }
    }
      
    return maxDepth;
  }
}


// Original solution


class Solution {
    
    public int maxDepth(TreeNode root) {
    return traverse(root, 0);
    }
    
    public int traverse(TreeNode node, int counter){
        if (node == null){ return counter;} 
        counter ++;  
        if(node.left == null && node.right == null){
            return counter;
        }   
        return Math.max(traverse(node.left, counter), traverse(node.right, counter));   
    }
}

