
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Build the graph as an adjacency list
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] flight : flights) {
           int from = flight[0];
           int to = flight[1];
           int cost = flight[2];
           graph.putIfAbsent(from, new ArrayList<>());
           graph.get(from).add(new int[]{to, cost});
        }

        // Step 2: Initialize distance array with Infinity
        int[][] dist = new int[n][k + 2]; 
        for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0; // Starting city has cost 0 with 0 stops

        // Step 3: Priority Queue to process nodes by lowest cost (cost, city, stops)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0}); // Start from src city

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int city = curr[1];
            int stops = curr[2];

            if (cost > dist[city][stops]) continue;  // Skip if current cost is worse
            if (city == dst) return cost;            // Destination reached
            if (stops > k) continue;                 // Exceeds allowed stops

            // Explore neighbors
            if(graph.containsKey(city)) {
                for(int[] neighbor : graph.get(city)) {
                    int neighbor_city = neighbor[0];
                    int next_cost = neighbor[1];
                    int new_cost = cost + next_cost;

                    // If new cost is better, update and push to queue
                    if(new_cost < dist[neighbor_city][stops + 1]) {
                        dist[neighbor_city][stops + 1] = new_cost;
                        pq.offer(new int[]{new_cost, neighbor_city, stops + 1});
                    }
                }
            }
        }
        return -1;
    }
}