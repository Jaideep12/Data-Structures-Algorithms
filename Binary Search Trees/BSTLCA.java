// 235. Lowest Common Ancestor of a Binary Search Tree
// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        int curr = root.val;

        if(curr<p.val && curr<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(curr>p.val && curr>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        return root;
    }
}
