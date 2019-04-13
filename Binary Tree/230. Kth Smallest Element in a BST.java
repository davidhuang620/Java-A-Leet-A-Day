/*
In Order Traversal ITERVATIVE 

BE aware of the follow up question !!

Follow UP
What if the BST is modified (insert/delete operations) often
and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?

Use a HashMap to store how many node does one node have under it O(N)
Then when we are looking for kth smallest element, we can use k select with O(k)

*/

// Use in Order Traversal  
// First Approach

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pt = root;
        int counter = 0;
        while ((pt != null || !stack.isEmpty())){
            while(pt != null){
                stack.push(pt);
                pt = pt.left;
            }
            pt = stack.pop();
            counter++;
            if (counter == k){
                break;
            }
            pt = pt.right;
        }
        return pt.val;
    }
}

/* 
Follow UP
What if the BST is modified (insert/delete operations) often
and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?

Use a HashMap to store how many node does one node have under it O(N)
Then when we are looking for kth smallest element, we can use k select with O(k)

*/

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null){ return -1; }
        HashMap<TreeNode, Integer> map = new HashMap<>();
        countNode(root, map);
        return kHelper(root, map, k);
    }
    
    private int kHelper(TreeNode node, HashMap<TreeNode, Integer> map, int k){
        int rank = node.left == null ? 1 : map.get(node.left) + 2;
        while (rank != k){
            if (rank > k){
                node = node.left;
            } else {
                node = node.right;
                k = k - rank;
            }
            rank = node.left == null ? 1 : map.get(node.left) + 2;
        }
        return node.val;
    }
    
    private int countNode(TreeNode root, HashMap<TreeNode, Integer> map){
        if (root == null){
            return 0;
        }
        int left = countNode(root.left, map);
        int right = countNode(root.right, map);
        map.put(root, left + right);
        return left + right + 1;
    }
}


