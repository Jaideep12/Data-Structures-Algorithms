//This problem gets all shortest path distances from a source node
//we are using an undirected graph for this problem
//BFS Approach

class ShortestPaths {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        int dist[] = new int[n];
        
        for(int i=0;i<n;i++){
            dist[i] = (int)1e9;
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

      //adjacency list creation
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        dist[src] = 0;

      //always start from source node
        queue.add(src);
        
        while(!queue.isEmpty()){
            int node = queue.poll();

          //only put next node in queue if distance is less
            for(int a : adj.get(node)){
                if(dist[node]+1 < dist[a]){
                    dist[a] = dist[node]+1;
                    queue.add(a);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
}
