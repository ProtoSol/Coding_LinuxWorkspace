package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// This type of sorting is also called as Khan's Algorithm
// This algorithm can be used to detect cycles in a directed graph as,
    // if the topo array doesnt has the same size as the input array then cycle is present
    // otherwise no cycle is present.
public class TopologicalSortBFS {
    public static void main(String[] args) {
        // Create a graph with 6 vertices
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);

        // Perform topological sort
        int[] topo = Solution.topoSort(V, adj);

        // Print the topological order
        System.out.println("Topological Order:");
        for (int i = 0; i < V; i++) {
            System.out.print(topo[i] + " ");
        }
    }
}

class Solution{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        // Fill the InDegree Array
        int inDegree[] = new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                inDegree[it]++;
            }
        }
        // Make the Queue and fill with the nodes having 0 indegree value
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if (inDegree[i] == 0){
                q.add(i);
            }
        }
        // Perform BFS and put the values in the result array.
        int topo[] = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            for(int it : adj.get(node)){
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        // Return the answer Arrau
        return topo;
    }
}
