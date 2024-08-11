package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFS {
    public static void main(String[] args) {
        
    }


    public static void calculateInDegree(ArrayList<Graphs.Edge>[] graph , int[] indegree){
        for (int i = 0; i< graph.length ; i++){     //every vertex has become i
            int vertex  = i;
            for (int j =0; j< graph[vertex].size()  ;j++){
                Graphs.Edge e = graph[vertex].get(j);
                indegree[e.dest]++;
            }

        }
    }
    public static  void topSort(ArrayList<Graphs.Edge>[] graph){
        int []indegree = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i< indegree.length ; i++){
            if (indegree[i] == 0){
                q.add(i);
            }
        }

        //bfs
        //Until the q does not become empty we need to traverser
        while (!q.isEmpty()){
            int curr = q.remove();
            System.out.println(curr + " ");

            for (int i = 0; i< graph[curr].size() ;i++){
                Graphs.Edge e = graph[curr].get(i);
                indegree[e.dest] --;
                if (indegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        System.out.println();


    }
}
