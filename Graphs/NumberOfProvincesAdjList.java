class NumberOfProvincesAdjList {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean visited[] = new boolean[V];
        int components = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                components++;
                dfs(adj,V,visited,i);
            }
        }
        return components;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int V, boolean [] visited,int node){
        visited[node] = true;
        for(int i=0;i<V;i++){
            if(adj.get(node).get(i)==1 && !visited[i]){
                dfs(adj,V,visited,i);
            }
        }
    }
}
