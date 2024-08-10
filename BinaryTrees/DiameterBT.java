class Solution {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return max;
    }

    public int getDiameter(TreeNode root){
        if(root==null) return 0;

        int left = getDiameter(root.left);
        int right = getDiameter(root.right);

        max = Math.max(max,left+right);

        return 1 + Math.max(left,right);
    }
}
