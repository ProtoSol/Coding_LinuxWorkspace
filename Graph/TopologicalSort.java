package Graph;

import java.util.*;

public class TopologicalSort {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list representation

    // Constructor
    public TopologicalSort(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // Recursive function for topological sort
    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited
        visited[v] = true;

        // Recur for all adjacent vertices
        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }

        // Push current vertex to stack which stores the result
        stack.push(v);
    }

    // Main function to perform topological sort
    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Call the recursive helper function for all vertices
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print contents of stack
        System.out.println("Topological sort order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();
    }
}