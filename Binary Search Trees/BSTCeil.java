// Given a BST and a number X, find Ceil of X.
// Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.

// If Ceil could not be found, return -1.

class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        
        int ans = -1;
        
        while(root!=null){
            
            if(root.data>=key){
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
