package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingUsingDFS {

    public static void topSort(ArrayList<Graphs.Edge>[] graph ){
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i= 0;  i< graph.length ; i++ ){
            if (!vis[i]){       //if any of my node is unvisited  we call the DFS function
                    topSortUtil( graph,  i , vis , st );        //this will be my modified DFS function
            }
        }

        while (st.isEmpty()){
            System.out.println(st.pop());
        }
    }

    private static void topSortUtil(ArrayList<Graphs.Edge>[] graph, int curr, boolean[] vis, Stack<Integer> st) {
        vis[curr] = true;


        for (int i = 0; i< graph[curr].size() ;i++ ){
            Graphs.Edge e = graph[curr].get(i);
            //e.dest will be the nieghbout
            if (!vis[e.dest]){
                topSortUtil(graph , e.dest, vis , st);
            }
        }

        st.push(curr);

    }
}
