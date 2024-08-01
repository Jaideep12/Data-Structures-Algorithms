class graphDFS {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean [] visited = new boolean[V];
        visited[0] = true;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0,adj,list,visited);
        return list;
    }
    
    public void dfs(int V, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>list
    ,boolean visited[]){
        
        visited[V] = true;
        list.add(V);
        
        for(int a : adj.get(V)){
            if(!visited[a]){
                dfs(a,adj,list,visited);
            }
        }
        
    }
}
