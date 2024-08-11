// 105. Construct Binary Tree from Preorder and Inorder Traversal
// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {    
        HashMap<Integer,Integer> inMap = new HashMap<>();

        for(int i = 0; i<inorder.length; i++){
            inMap.put(inorder[i],i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);

        return root;
    }

    public TreeNode buildTree(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd, Map<Integer,Integer> inMap){
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.get(root.val);

        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);

        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
