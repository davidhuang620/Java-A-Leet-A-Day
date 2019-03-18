
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
4. Stack.push()
5. Stack.pop()
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



// Iteration BFS

/* Keys
1. Similar to DFS, but implement with Queue instead of Stack
2. Queue <type> variable = new LinkedList<>();
3. Queue.add //EnQueue
4. Queue.poll // DeQueue
5. For this problem, since we only care about the depth, we don't need another data structure for storing levels, 
we can just increment it while scanning different levels.

*/

class Solution {
  public int maxDepth(TreeNode root){
   
    if(root == null){
        return 0;        
    }
      
    Queue<TreeNode> nodeQueue = new LinkedList<>();

    int maxDepth = 0;

    nodeQueue.add(root);
    
    while(!nodeQueue.isEmpty()){
        
        int size = nodeQueue.size();
        while(size-- >0){
          TreeNode node = nodeQueue.poll();
          if(node.right != null){
            nodeQueue.add(node.right);
          }

          if(node.left != null){
            nodeQueue.add(node.left);
          }
        }
      maxDepth ++;
       
    }
      
    return maxDepth;
  }
}
