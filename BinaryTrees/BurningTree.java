// Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
// Note: The tree contains unique values.

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        //Step 1 would be to find the node and get its address'
        
        Node targetNode = findNode(root,target);
        
        //Step 2 would be to get all parent mappings
        
        Map<Node,Node> parentMap = new HashMap<>();
        getParents(root,parentMap);
        Map<Node,Boolean> v = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        v.put(targetNode,true);
        
        q.add(targetNode);
        
        int time = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                if(temp.left!=null && !v.containsKey(temp.left)){
                    q.add(temp.left);
                    v.put(temp.left,true);
                }
                if(temp.right!=null && !v.containsKey(temp.right)){
                    q.add(temp.right);
                    v.put(temp.right,true);
                }
                if(parentMap.containsKey(temp) && parentMap.get(temp)!=null
                && !v.containsKey(parentMap.get(temp))){
                    q.add(parentMap.get(temp));
                    v.put(parentMap.get(temp),true);
                }
            }
        }
        
        return time-1;
        
    }
    
    public static Node findNode(Node root, int target){
        
        if(root==null || root.data==target){
            return root;
        }
        
        Node left = findNode(root.left,target);
        if(left!=null) return left;
        Node right = findNode(root.right,target);
        return right;
        
    }
    
    public static void getParents(Node root,Map<Node,Node> parentMap){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        parentMap.put(root,null);
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left!=null){
                q.add(temp.left);
                parentMap.put(temp.left,temp);
            }
            if(temp.right!=null){
                q.add(temp.right);
                parentMap.put(temp.right,temp);
            }
        }
    }
}
