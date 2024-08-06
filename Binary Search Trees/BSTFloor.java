// You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of the BST which is smaller than or equal to x.
// Note: when x is smaller than the smallest node of BST then returns -1.

class Solution {
    public static int floor(Node root, int key) {
        if (root == null) return -1;
        // Code here
        
        int ans = -1;
        
        while(root!=null){
            
            if(root.data<=key){
                ans = root.data;
            }
            if(ans== key){
                break;
            }
            
            if(root.data < key){
                root = root.right;
            }else{
                
                root = root.left;
            }
        }
        return ans;
    }
}
