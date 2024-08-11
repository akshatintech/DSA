package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    public static void main(String[] args) {

    }

    public static boolean isBipartite(ArrayList<Graphs.Edge>[] graph){
        int[] color = new int[graph.length];

        for (int i= 0 ; i< color.length ; i++){
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < graph.length ;i ++){
            if (color[i] == -1){        //Perform BFS
                q.add(i);
                color[i] = 0;//yellow color
                while (!q.isEmpty()){
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size() ;j++){
                        Graphs.Edge e = graph[curr].get(j);     //e.dest
                        if (color[e.dest] == -1){
                            int nextColor;
                            if (color[curr] == 0) {
                                nextColor = 1;
                            } else {
                                nextColor = 0;
                            }
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        }
                        else if(color[e.dest] == color[curr]){
                            return false;           //Not Bipartite
                        }
                    }
                }
            }
        }

        return true;
    }
}
