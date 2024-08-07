// 1008. Construct Binary Search Tree from Preorder Traversal

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode parent = stack.peek();

            // Adjust parent and stack until the current node fits the BST property
            while (!stack.isEmpty() && stack.peek().val < node.val) {
                parent = stack.pop();
            }

            // The new node is either a left or right child of the last node popped
            if (node.val < parent.val) {
                parent.left = node;
            } else {
                parent.right = node;
            }

            // Push the new node to the stack
            stack.push(node);
        }

        return root;

    }
}
