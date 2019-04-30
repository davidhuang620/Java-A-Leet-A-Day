
/*
Pre Order
Root Left Right 
(pre => root at the start)
首先访问根结点，然后遍历左子树，最后遍历右子树。遍历左、右子树时，仍按先序遍历。若二叉树为空则返回。
该过程可简记为根左右，注意该过程是递归的。
*/

// 将根作为root，空ArrayList作为result传入，即可得到整棵树的遍历结果
private void traverse(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
        return;
    }
    result.add(root.val);
    traverse(root.left, result);
    traverse(root.right, result);
}

/*
In Order
Left Root Right
(In => Root in the middle)
首先遍历左子树，然后访问根结点，最后遍历右子树。遍历左、右子树时，仍按中序遍历。若二叉树为空则返回。简记为左根右。
*/

private void traverse(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
        return;
    }
    traverse(root.left, result);
    result.add(root.val);  // 注意访问根节点放到了遍历左子树的后面
    traverse(root.right, result);
}

/*
Post Order 
Left Right Root 
(Post => Root at the end)
首先遍历左子树，然后遍历右子树，最后访问根结点。遍历左、右子树时，仍按后序遍历。若二叉树为空则返回。简记为左右根。
*/

private void traverse(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
        return;
    }
    traverse(root.left, result);
    traverse(root.right, result);
    result.add(root.val);  // 注意访问根节点放到了最后
}






/*
Iterative
*/

// Pre Order Traverse
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.add(p.val);  // Add before going to children
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            p = node.right;   
        }
    }
    return result;
}


// In Order Traverse
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            result.add(node.val);  // Add after all left children
            p = node.right;   
        }
    }
    return result;
}


// Post Order Traverse
public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.addFirst(p.val);  // Reverse the process of preorder
            p = p.right;             // Reverse the process of preorder
        } else {
            TreeNode node = stack.pop();
            p = node.left;           // Reverse the process of preorder
        }
    }
    return result;
}


