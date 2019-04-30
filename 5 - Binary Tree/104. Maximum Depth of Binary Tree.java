class Solution {

    public int maxDepth(TreeNode root){
        
        if (root == null){
            return 0;
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}



class Solution {

  private int maxDep = 0;
  public int maxDepth(TreeNode root){
   

    traverse(root, 1);
      
    return maxDep;
    }
    
    private void traverse(TreeNode root, int depth){
        
        if (root == null){
            return;
        }
        maxDep = Math.max(maxDep, depth);
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }
}
