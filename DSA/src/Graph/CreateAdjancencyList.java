package Graph;

import java.util.ArrayList;

public class CreateAdjancencyList {

    public static void createAdjacency(int[][] isConnected){
        int V = isConnected[0].length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        //create a n list
        for (int i = 0; i< V ;i++){
            adjList.add(new ArrayList<>());
        }

        //add all the nieghbours along with tha parent in the list
        for (int i = 0; i < V ; i++){
            for (int j = 0; j< V ; j++){
                if (isConnected[i][j] == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
    }


    public static int findCircleNum(int[][] isConnected) {
        int V = isConnected[0].length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<Integer>());
        }
    /*
    This is the case with undirected graphs where we store the numbers with thier neighbours

    1 = {2,4}
    2 = {1,3}
    3 = {2,4,5}
    4 = {1,3,5}
    5 = {4,3}


    In case of weighted graphs we will store the pairs along with the weights
    node = {{neighbour , weight} ,{neighbour , weight} .... }
    1 = { {2,3}, {4,6}}
    2 = { {1,3},{3,4}}
    3 = {{2,4} , {4,5} , {5,1}}
    4 = {{1,6} ,{3,5} , {5,2}}
    5 = {4,2} ,{3,1}}
     */
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int vis[] = new int[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                count++;
                dfs(i,adjList,vis);
            }
        }

        return count;
    }

    public static void dfs(int node , ArrayList<ArrayList<Integer>> adj , int vis[]){

        vis[node] = 1;

        for(int i : adj.get(node)){
            if(vis[i]==0){
                dfs(i,adj,vis);
            }
        }
    }
}
