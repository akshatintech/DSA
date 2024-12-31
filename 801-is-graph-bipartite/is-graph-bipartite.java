class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[graph.length];
        for(int i =0;i < V ;i++){
            color[i] =-1;
        }


        for(int i = 0;i < V ;i++){
            if(color[i] == -1){
                if(dfsCall(i , 0 , graph , color) == false){
                    return false;
                }
            }
        }
        

        return true;
    }


    public boolean dfsCall(int node , int col , int[][] graph , int[] color){
        color[node] = col;

        for(int it : graph[node]){
            if(color[it] == -1){
                if(dfsCall(it , 1-col , graph , color) == false)return false;
            }
            else{
                if(color[it] == col){
                    return false;
                }
            }
        }

        return true;
    }
}