class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: if both trees are null, they are identical
        if (p == null || q == null) {
            return p==q;
        }
        // Recursively check if the left and right subtrees are identical
        return (p.val==q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
