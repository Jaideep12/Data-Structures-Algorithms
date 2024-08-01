class DirectedCyclic {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
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
        
        int result[] = new int [V];
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
        if(x==V) return false;
        return true;
    }
}
