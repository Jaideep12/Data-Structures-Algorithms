class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(root,new ArrayList<>(), result);
        return result;
    }
    
    public static void helper(Node root, ArrayList<Integer> current, 
    ArrayList<ArrayList<Integer>> result){
        
        if(root==null){
            return;
        }
        current.add(root.data);
        if(root.left==null && root.right==null){
            result.add(new ArrayList<>(current));
        }else{
            helper(root.left,current,result);
            helper(root.right,current,result);
        }
        current.remove(current.size()-1);
    }
}
