//Dijkstra implementation for undirected graph
//Priotiry queue to store elements in the format (distance,node) to pick the least distance everytime
//

class DijkstraUndirected
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int distance [] = new int [V+1];
        
        for(int i=0;i<distance.length;i++){
            distance[i] = (int)1e9;
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        queue.add(new int [] {0,S});
        
        distance[S] = 0;
        
        while(!queue.isEmpty()){
            int [] temp = queue.remove();
            
            int dist = temp[0];
            int node = temp[1];
            
            for(List<Integer> t : adj.get(node)){
                int n = t.get(0);
                int d = t.get(1);
                
                if(dist + d < distance[n]){
                    distance[n] = dist + d;
                    queue.add(new int [] {dist+d,n});
                }
            }
        }
        
        for(int i=0;i<distance.length;i++){
            if(distance[i]==(int)1e9){
                distance[i] = -1;
            }
        }
        
        return distance;
    }
}
