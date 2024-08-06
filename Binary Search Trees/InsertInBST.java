// 701. Insert into a Binary Search Tree
// You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

// Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
  
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        TreeNode current = root;
        while(true){
            if(val>root.val){
                if(root.right==null){
                    TreeNode node = new TreeNode(val);
                    root.right=node;
                    break;
                }else{
                    root = root.right;
                }
            }else{
                if(root.left==null){
                    TreeNode node = new TreeNode(val);
                    root.left=node;
                    break;
                }else{
                    root=root.left;
                }
            }
        }
        return current;
    }
}
