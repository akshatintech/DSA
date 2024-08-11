package Graph;

import java.util.ArrayList;

public class DetectionOfCycle {

    public static boolean DetectCycle(ArrayList<Graphs.Edge>[] graph){
        boolean vis[]  = new boolean[graph.length];

        for(int i = 0; i < graph.length ; i++){
            if(!vis[i]){
                if (detectCycleUtil(graph , vis, i ,-1)){
                    return true;
                    //cycle exists in one of the parts
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Graphs.Edge>[] graph , boolean vis[] , int curr , int par) {
        vis[curr] = true;

        for(int i = 0; i< graph[curr].size() ; i++){
            Graphs.Edge e= graph[curr].get(i);
            //case 3
            if(!vis[e.dest] ){
                if(detectCycleUtil(graph , vis ,e.dest , curr)){
                    return true;
                }

            }

            //case 1
            else if(vis[e.dest] && e.dest != par){
                return true;
            }

            //case 2  ->> do nothing contine

        }

        return false;
    }

}
