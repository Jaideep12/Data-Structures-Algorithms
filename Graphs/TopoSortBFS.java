//This algorithm uses the concept of storing indegrees to check which comes first
//populate all indegrees
//for nodes with indegree 0 they can come at first
//keep decrementing indegree.

class TopoSortBFS
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        int [] indegree = new int [V];
        
        for(int i=0;i<V;i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        
        int[] result = new int[V];
        int x=0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                
                int node = queue.poll();
                result[x++] = node;
                for(int j : adj.get(node)){
                    indegree[j]--;
                    if(indegree[j]==0){
                        queue.add(j);
                    }
                }
            }
        }
        return result;
    }
}
