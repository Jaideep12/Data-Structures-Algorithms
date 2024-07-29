// There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

class CheapestFlights {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        int m = flights.length; 
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]}); 
        }

        Queue<int[]> q = new LinkedList<>(); 
        
        q.add(new int[]{0, src, 0});

        // Distance array to store the updated distances from the source. 
        int[] dist = new int[n]; 
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9); 
        }
        dist[src] = 0;
        while(!q.isEmpty()) {
            int[] it = q.peek(); 
            q.remove(); 
            int stops = it[0]; 
            int node = it[1]; 
            int cost = it[2]; 
            
            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue; 
            for(int[] iter: adj.get(node)) {
                int adjNode = iter[0]; 
                int edW = iter[1];
                
                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW; 
                    q.add(new int[]{stops + 1, adjNode, cost + edW}); 
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1; 
        return dist[dst]; 
    }
}
