/*

Search on BST O(h) where h = tree height 

in order iteratve O(N) careful of edge cases
check if there's first node and second node
also initialize the int to avoid compiler error


*/



// O(h)

class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null){
            return -1;
        }
        int min = root.val, max = root.val;
        while (root != null){
            if (root.val >= target){
                max = Math.abs(root.val - target) < Math.abs(max - target) ? root.val : max;
                root = root.left;
            } else {
                min = Math.abs(target - root.val) < Math.abs(target - min) ? root.val : min;
                root = root.right;
            }
        }
        
        return Math.abs(target - min) < Math.abs(max - target) ? min : max;
        
    }
}


// in order traversal

// in order iteratve O(N) careful of edge cases
// check if there's first node and second node
// also initialize the int to avoid compiler error

class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null){
            return -1;
        }
        int min = 0, max = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        boolean firstNode = true;
        boolean lastNode = true;
        
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val >= target){
                max = node.val;
                // since there's at least one node is greater than target
                // it's not the last node
                lastNode = false;
                break;
            } else {
                // since there's at least one node is less than target;
                // it's not the first node
                min = node.val;
                firstNode = false;
            }
            node = node.right;
        }
        
        if (firstNode){
            return max;
        }
        if (lastNode){
            return min;
        }
        
        return (target - min) < (max - target) ? min : max;
    }
}

