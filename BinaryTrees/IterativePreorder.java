class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root==null) return res;

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode r = stack.pop();

            if(r.right!=null){
                stack.push(r.right);
            }
            if(r.left!=null){
                stack.push(r.left);
            }

            res.add(r.val);
        }
        return res;
    }
}
