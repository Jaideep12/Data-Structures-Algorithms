// 450. Delete Node in a BST
// Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

// Basically, the deletion can be divided into two stages:

// Search for a node to remove.
// If the node is found, delete the node.

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val==key){
            return helper(root);
        }
        TreeNode dummy = root;
        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val==key){
                    root.left = helper(root.left);
                    break;
                }else{
                    root=root.left;
                }
            }else{
                if(root.right!=null && root.right.val==key){
                    root.right = helper(root.right);
                    break;
                }else{
                    root=root.right;
                }
            }
        }
        return dummy;
    }

    public TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }else{
            TreeNode rchild = root.right;
            TreeNode lright = findLastRight(root.left);
            lright.right = rchild;
            return root.left;
        }
    }

    public TreeNode findLastRight(TreeNode root){
        if(root.right==null){
            return root;
        }
        return findLastRight(root.right);
    }
}
