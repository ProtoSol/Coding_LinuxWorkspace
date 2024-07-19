// Graph is a collection of nodes and connections.
// It can also be called as collection of vertices and edges
// Binary tree is a Graph but it has some restrictions.
    // One parent and 2 children only.
// It can have cycles.
// Facebooks uses a type of graph in friends recommendation.
// Google maps uses graph technology
// There are two types of graph
    // Directed and Undirected Graph.
// There are individual connected components present in the graph.
// Terminologies
    // In Degree -> No. of Nodes going to one Node.
    // Out Degree -> One Node going to multiple Nodes.
// Cyclic v/s Acyclic Graph
        // We mark the path true and check if true comes again.
    // If a cycle is present then it is Cyclic. 
    // If a cycle is not present then it is Acyclic.
// Algorithms of Graph
    // Linked List -> Head was mentioned.
    // Binary Tree -> Root was mentioned.
    // For Graph there won't be any hints but only patterns.
        // Nodes will be mentioned.
        // Labels will be present somewhere.
        // Story is used to explain the problem.
// There are two types of Traversal DFT or BFT.
// Input format would be 2D Array.
// Connection will be present A -> B -> C
// Can be Directed or Undirected.
// We have to Preprocess for faster processing.
    // Map is required to maintain the information of the neighbors.

package Graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphDemo {
    // We need data of vertices and edges
    // 2D Array for Edges
    // 1D Array for Vertices
    static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>(); // Unsorted, Unordered
        // Traverse the Graph
        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            // Directed
            if (!graph.containsKey(vertex1)) {
                graph.put(vertex1, new ArrayList<>());
            }
            graph.get(vertex1).add(vertex2);

            // Undirected Graph (Bidirectional)
            // It can go two ways
            // Uncomment the following lines for undirected graph
            // if (!graph.containsKey(vertex2)) {
            //     graph.put(vertex2, new ArrayList<>());
            // }
            // graph.get(vertex2).add(vertex1);
        }
        return graph;
    }

    public static void main(String[] args) {
        // Example usage
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        
        // Print the graph
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " is connected to: " + entry.getValue());
        }
    }
}

