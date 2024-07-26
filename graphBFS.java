class graphBFS {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean [] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        visited[0]=true;
        
        while(!q.isEmpty()){
            int n = q.poll();
            bfs.add(n);
            
            for(int a : adj.get(n)){
                if(visited[a]==false){
                    visited[a] = true;
                    q.add(a);
                }
            }
        }
        
        return bfs;
    }
}
