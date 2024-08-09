class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        if(root==null) return result;

        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode c = queue.poll();
                if(c.left!=null){
                    queue.add(c.left);
                }
                if(c.right!=null){
                    queue.add(c.right);
                }
                temp.add(c.val);
            }
            result.add(temp);
        }
        return result;
    }
}
