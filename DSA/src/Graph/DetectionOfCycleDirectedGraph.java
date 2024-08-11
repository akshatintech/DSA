package Graph;

import java.util.ArrayList;

public class DetectionOfCycleDirectedGraph {

    public static boolean isCycle(ArrayList<Graphs.Edge>[] graph){

        boolean[] vis  = new boolean[graph.length];

        boolean[] stack = new boolean[graph.length];

        for(int i = 0; i< graph.length ; i++){

            if (!vis[i]){
                if(isCycleUtil(graph , i , vis , stack)){
                    return true;
                }
            }
        }

        return  false;
    }

    private static boolean isCycleUtil(ArrayList<Graphs.Edge>[] graph, int curr, boolean[] vis , boolean[] stack) {
            //This function will do the Actual DFS

        vis[curr] = true;
        stack[curr] = true;

        //now we will run the loop for all the neighbours

        for(int i = 0; i<graph[curr].size() ;i++){
            Graphs.Edge e = graph[curr].get(i);
            if (stack[e.dest] == true){         //if the neighbour of the node exists in the stack which means cycle exists
                return true;

            }

            if(!vis[e.dest] && isCycleUtil(graph , e.dest , vis , stack)){

                //if my neighbour is unvisited and we check whether the cycle exists over there or not
                return true;

            }
        }
        stack[curr] = false;
        return false;

    }



    static void createGraph(ArrayList<Graphs.Edge> graph[]){
        for(int i = 0;i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Graphs.Edge(0 ,2));

        graph[1].add(new Graphs.Edge(1,0));

        graph[2].add(new Graphs.Edge(2,3));

        graph[3].add(new Graphs.Edge(3, 0));
    }

    public static void main(String[] args) {
        int  V= 4;
        ArrayList<Graphs.Edge> graph[] = new ArrayList[V];

        createGraph(graph);
    }
}
