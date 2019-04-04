 public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        // use isEmpty instead of queue.poll != null which will actually pop the element
        while(!queue.isEmpty()){
        
            ArrayList<Integer> level = new ArrayList<>();
            int queueSize = queue.size();
            
            for(int i = 0; i < queueSize; i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                level.add(node.val);
            }
            
            ans.add(level);
            
        }
        return ans;
    }
    
    
