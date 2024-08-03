class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the distance matrix
        int[][] dist = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }
        
        // Fill the distance matrix with initial edge weights
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        
        // Floyd-Warshall algorithm to find all pairs shortest path
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }
        
        int countCity = n;
        int cityNo = -1;
        
        // Find the city with the minimum number of neighbors within the distance threshold
        for (int city = 0; city < n; city++) {
            int count = 0;
            for (int adj = 0; adj < n; adj++) {
                if (dist[city][adj] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= countCity) {
                countCity = count;
                cityNo = city;
            }
        }
        
        return cityNo;
    }
}
