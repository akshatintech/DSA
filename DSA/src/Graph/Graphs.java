package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs {

    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src , int dest , int wt){
            this.src = src;
            this.dest = dest;
            this.wt =wt;
        }

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){

        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];

        q.add(0);       //adding the source element

        while (!q.isEmpty()){       //while the q is not empty
                int curr = q.remove();

                if(!vis[curr]){     //if the node is note visited yet
                    System.out.print(curr +" ");
                    vis[curr] = true;
                    for(int i = 0; i< graph[curr].size() ; i++ ){           //get all the neighbouring elements of the node
                        Edge e = graph[curr].get(i);                        //destination of each edge is the neighbour
                        q.add(e.dest);                          //add the element in the queue

                    }

                }
        }
    }





    public static void dfs(ArrayList<Edge>[] graph , int curr , boolean vis[]){
        //visit
        //dfs is done using the recursive function by calling the immediate neighbour of the node
        System.out.print(curr + " ");
        vis[curr] =true;
        for(int i = 0 ; i< graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            dfs(graph , e.dest , vis);
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph , int src , int dest , boolean vis[] ){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int i = 0; i< graph[src].size() ; i++){
            Edge e = graph[src].get(i);

            //e.dest == neighbour
            if (!vis[e.dest] && hasPath(graph , e.dest, dest, vis)){
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
    }
}
