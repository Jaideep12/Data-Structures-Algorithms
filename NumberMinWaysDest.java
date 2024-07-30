// 1976. Number of Ways to Arrive at Destination
// You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

// You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

// Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

class NumberMinWaysDest {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] a : roads){
            adj.get(a[0]).add(new int[]{a[1],a[2]});
            adj.get(a[1]).add(new int[]{a[0],a[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue <> ((x, y) -> x[0] - y[0]);

        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new int[]{0, 0});

        // Define modulo value
        int mod = (int)(1e9 + 7);

        while (pq.size() != 0) {
            int dis = pq.peek()[0];
            int node = pq.peek()[1];
            pq.remove();

            for (int [] it : adj.get(node)) {
                int adjNode = it[0];
                int edW = it[1];

                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the no. of ways the same.
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new int[]{dis + edW, adjNode});
                    ways[adjNode] = ways[node];
                } 

                    // If we again encounter a node with the same short distance
                    // as before, we simply increment the no. of ways.
                    else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        // Finally, we return the no. of ways to reach
        // (n-1)th node modulo 10^9+7.
        return ways[n - 1] % mod;
    }
}
