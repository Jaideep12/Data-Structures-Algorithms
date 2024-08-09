class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while(true){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                res.add(node.val);
                node=node.right;
            }
        }
        return res;
    }
}
