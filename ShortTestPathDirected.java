//finding the shortest paths from 0th node to all other nodes
//Step 1 - Perform topological sorting on the graph
//Step 2 - Pick elements from stack and keep updating the distance array

class ShortTestPathDirected {

	public int[] shortestPath(int N,int M, int[][] edges) {
	    List<List<int[]>> adj = new ArrayList<>();
	    
	    Stack<Integer> stack = new Stack<>();
	    
	    for(int i=0;i<N;i++){
	        adj.add(new ArrayList<int[]>());
	    }
	    
	    for(int i=0;i<M;i++){
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        
	        adj.get(u).add(new int[]{v,wt});
	    }
	    
	    boolean visited[] = new boolean [N];
	    
	    for(int i=0;i<N;i++){
	        if(!visited[i]){
	            topoSort(adj,stack,visited,i);
	        }
	    }
	    
	    int [] dist = new int[N];
	    
	    for(int i=0;i<N;i++){
	        dist[i] = (int) 1e9;
	    }
	    
	    dist[0] = 0;
	    while(!stack.isEmpty()){
	        int node = stack.pop();
	        
	        for(int a[] : adj.get(node)){
	            int v = a[0];
	            int wt = a[1];
	            
	            if(dist[node]+wt < dist[v]){
	                dist[v] = dist[node] + wt;
	            }
	        }
	    }
	    
	    for(int i=0;i<N;i++){
	        if(dist[i]==1e9){
	            dist[i] = -1;
	        }
	    }
	    
	    //System.out.println(stack);
	    return dist;
	}
	
	public void topoSort(List<List<int[]>> adj, Stack<Integer> stack,
	boolean visited[], int node){
	    
	    visited[node] = true;
	    
	    for(int a[] : adj.get(node)){
	        if(!visited[a[0]]){
	            topoSort(adj,stack,visited,a[0]);
	        }
	    }
	    stack.push(node);
	}
}
