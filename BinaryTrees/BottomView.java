class Pair{
    Node node;
    int ind;
    public Pair(Node _node, int _ind){
        this.node = _node;
        this.ind = _ind;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(root,0));
        
        Map<Integer,Integer> values = new TreeMap<>();
        
        while(!queue.isEmpty()){
            Pair t = queue.poll();
            
            Node temp = t.node;
            int index = t.ind;
            
            if(temp.left!=null){
                queue.add(new Pair(temp.left,index-1));
            }
            
            if(temp.right!=null){
                queue.add(new Pair(temp.right,index+1));
            }
            
            values.put(index,temp.data);
        }
        //System.out.println(values);
        
        for(Map.Entry<Integer,Integer> entry : values.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
