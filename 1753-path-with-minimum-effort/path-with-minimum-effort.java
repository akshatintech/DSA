class Solution {
    class Tuple{
        int row;
        int col;
        int dist;

        Tuple(int row , int col ,int dist ){
             this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.dist -y.dist);
        int[][] dist = new int[n][m];


        for(int i =0; i < n ;i++){
            for(int j = 0; j < m ;j++){
                dist[i][j] = (int)(1e9);
            }
        }


        dist[0][0] =0;
        pq.add(new Tuple(0, 0, 0));
        int dr[] = {-1 ,0 ,1 , 0};
        int dc[] = {0 , 1, 0 , -1};


        while(pq.size() != 0){
            Tuple it = pq.peek();
            pq.remove();
            int row = it.row;
            int col = it.col;
            int diff = it.dist;

            if(row == n-1 && col == m-1){
                return diff;
            }


            for(int i =0; i < 4 ;i++){      //We will check for minimum difference in all the direction
            int nrow = row+ dr[i];
            int ncol = col + dc[i];


            if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m){
                int newEffort = Math.max(Math.abs(heights[row][col] -heights[nrow][ncol]) , diff);

                //if new effort is less than previous effort we update
                if(newEffort < dist[nrow][ncol]){
                    dist[nrow][ncol] = newEffort;
                    pq.add(new Tuple(nrow , ncol ,newEffort));
                }
            }

            }
        }

        return 0;
        
    }
}