class CycleDetectionBFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited [] = new boolean[V];
    
        for(int i=0;i<V;i++){
            if(!visited[i]){
               if(bfs(V,adj,visited,i)){
                   return true;
               }
            }
        }
        return false;
    }
    
    public boolean bfs(int V, ArrayList<ArrayList<Integer>> adj,
    boolean visited[], int node){
        visited[node] = true;
        Queue<int[]> queue = new LinkedList<>();
      //we will keep track of parent
        queue.add(new int [] {node,-1});
        
        while(!queue.isEmpty()){
            int temp[] = queue.poll();
            int current = temp[0];
            int parent = temp[1];
            
            for(int c : adj.get(current)){
                if(visited[c]==false){
                    visited[c] = true;
                    queue.add(new int [] {c,current});
                }
                  //if we are not coming from parent and the node is already visited that means its a cycle
                else if(c!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}
