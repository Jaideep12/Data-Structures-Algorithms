class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int level=1;

        Map<Integer,Integer> values = new TreeMap<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode t = queue.poll();
                values.put(level,t.val);

                if(t.left!=null) queue.offer(t.left);
                if(t.right!=null) queue.offer(t.right);
            }
            level++;
        }
        for(Map.Entry<Integer,Integer> entry : values.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
