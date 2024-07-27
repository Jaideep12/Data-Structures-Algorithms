//This works only for DAG
//Idea is to first store data in adjacency list and then go node by node by keeping every node in a stack
//basically if there is an edge u->v then u must always come before v in the final output
class TopoSort
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int [] visited = new int [V];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(V,i,adj,stack,visited);
            }
        }
        
        int result[] = new int [V];
        int x=0;
        while(!stack.isEmpty()){
            result[x++] = stack.pop();
        }
        return result;
    }
    
   static void dfs(int V, int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack
    ,int [] visited){
        visited[node] = 1;
        
        for(int a : adj.get(node)){
            if(visited[a]==0){
                dfs(V,a,adj,stack,visited);
            }
        }
        stack.push(node);
    }
}
