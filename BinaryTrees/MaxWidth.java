class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode _node, int _num){
        this.node = _node;
        this.num = _num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                int curmin=q.peek().num-min;
                TreeNode t = q.peek().node;

                q.poll();

                if(i==0) first=curmin;
                if(i==size-1) last=curmin;

                if(t.left!=null){
                    q.offer(new Pair(t.left,curmin*2+1));
                }
                if(t.right!=null){
                    q.offer(new Pair(t.right,curmin*2+2));
                }
            }
           ans=Math.max(ans,last-first+1); 
        }
        return ans;
    }
}
