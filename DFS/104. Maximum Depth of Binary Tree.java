
// Tree Traversal 


// Optimal

// Recursion

class Solution {
  public int maxDepth(TreeNode root){
    if(node == null){return 0;}    
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}

// Iteration
class Solution {
  public int maxDepth(TreeNode root){
   
  
  
  }
}


/* Improvement
1. variable counter could just be passed in the return statement.
2. Recursion can happens in just one function.
*/

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

