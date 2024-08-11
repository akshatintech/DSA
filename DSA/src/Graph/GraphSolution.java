package Graph;
import java.util.ArrayList;
import java.util.List;
public class GraphSolution {



    public static void main(String[] args) {
        int[][] arr= new int[][]{{1,2} , {2,3} , {5} , {0} , {5} , {6}};
        eventualSafeNodes(arr);


    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int V= graph.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i< V ;i++){          //Add new ArrayList depending on the number of nodes
            adjList.add(new ArrayList<>());
        }
        for (int i = 0;i <V ;i++ ){
            for (int j: graph[i]){
                adjList.get(i).add(j);
            }
        }

        boolean[] visited = new boolean[V];
        boolean[] safe = new boolean[V];
        boolean[] onPath = new boolean[V];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i< V ; i++){
            if (safeNodeUtil(i , visited , safe , onPath , adjList)){
                result.add(i);
            }
        }

        return ans;


    }

    private static boolean safeNodeUtil(int node, boolean[] vis, boolean[] safe, boolean[] onPath, ArrayList<ArrayList<Integer>> adjList) {


        if (vis[node] == true){
            return safe[node];
        }
        vis[node] = true;

        onPath[node] = true;

        for (int neighbour : adjList.get(node)){
            if (onPath[neighbour] || !safeNodeUtil(neighbour , vis , safe , onPath , adjList)){
                safe[node] = false;
                onPath[node] = false;
                return false;
            }

        }
        onPath[node] = false;
        safe[node] =false;

        return true;
    }
}
