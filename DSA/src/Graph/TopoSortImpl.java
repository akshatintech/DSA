package Graph;

import java.util.*;

public class TopoSortImpl {

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph (Example graph)
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Call the topoSort method
        int[] result = topoSort(V, adj);

        // Print the result
        System.out.println("Topological Sort of the given graph:");
        for (int i : result) {
            System.out.print(i + " ");
        }

        // Optionally, visualize the graph structure
        visualizeGraph(V, adj);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCall(i, vis, st, adj);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }

        return ans;
    }

    static void dfsCall(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfsCall(it, vis, st, adj);
            }
        }
        st.push(node);
    }

    static void visualizeGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        System.out.println("\nGraph Visualization:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

