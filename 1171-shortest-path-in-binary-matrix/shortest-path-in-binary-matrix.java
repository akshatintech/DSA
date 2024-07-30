class Solution {
    class Tuple{
        int first;
        int second;
        int third;
        Tuple(int first , int second , int third){
            this.first =  first;
            this.second= second;
            this.third = third;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] != 0){
            return -1;
        }

        if(n ==0 || m ==0){
            return 0;
        }
        if(n == 1 && m==1 ){
            return 1;

        }

        Queue<Tuple> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for(int i=0;i< n ;i++){
            for(int j = 0; j< m ;j++){
                dist[i][j] = (int)(1e9);
            }
        }

        dist[0][0] = 0;
        q.add(new Tuple(0 , 0 , 0));
        int[] dr = new int[]{0 , -1 , -1 , -1 , 0 , 1 , 1 , 1 };
        int[] dc = new int[]{-1, -1 ,  0 ,  1 , 1 , 1 , 0 ,-1 };

        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();

            int dis = it.first;
            int r  = it.second;
            int c = it.third;

            for(int i = 0; i< 8 ; i++){
                int nrow = r + dr[i];
                int ncol = c + dc[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && dis +1 < dist[nrow][ncol]){
                    dist[nrow][ncol] = 1+ dis;
                    
                    if(nrow == n -1 && ncol == m-1){
                        return dist[nrow][ncol]+1;
                    }
                     q.add(new Tuple(1 + dis , nrow , ncol));
                    
                }
            }
           
        }

        return -1;

        
    }
}