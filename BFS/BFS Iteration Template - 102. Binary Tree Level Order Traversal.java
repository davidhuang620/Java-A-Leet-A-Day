/*
能用 BFS 的一定不要用 DFS(除非面试官特别要求)
BFS 的两个使用条件
• 图的遍历(由点及面，层级遍历)
• 简单图最短路径
是否需要层级遍历
• size = queue.size()
拓扑排序必须掌握!
坐标变换数组
• deltaX, deltaY • inBound
*/

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
    
    
