package Graph;

import java.util.*;

public class TopologicalSort {
    // Start the Dfs for checking the Adj node and add to the stack at the last
    private static void dfs(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        for(int i : adj.get(node)){
            if(vis[i] == 0){
                dfs(i, vis, st, adj);
            }
        }
        st.push(node);
    }

    // Starts the sort with initializing preliminary items and a Stack
    static int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, vis, st, adj);
            }
        }
        // makes the result array
        int res[] = new int[V];
        int i = 0;
        while(!st.isEmpty()){
            res[i++] = st.pop();
        }
        return res;
    }

    // Main Body of the code
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Making the Graph structure
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }  

        // Adding edges to the graph
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Getting the result from the function call
        int[] result = topologicalSort(V, adj);
        // Printing the result
        System.out.println("Topological Sort of the graph:");
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}