class Solution {
    public boolean isBalanced(TreeNode root) {
        if(getHeight(root)==-1){
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode root){
        if(root==null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if(left==-1 || right==-1) return -1;

        if(Math.abs(left-right)>1){
            return -1;
        }

        return 1 + Math.max(left,right);
    }
}
