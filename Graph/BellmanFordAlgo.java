package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    int source;
    int target;
    int weight;
    Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
}

public class BellmanFordAlgo {
    void bellmanFord(List<Edge> edges, int numberOfVertex, int source) {
        int[] distance = new int[numberOfVertex];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 1; i < numberOfVertex; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.target;
                int weight = edge.weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.target;
            int weight = edge.weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        printSPT(distance);
    }

    void printSPT(int[] distance) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }

    public static void main(String[] args) {
        int numberOfVertex = 5;
        List<Edge> edges = new ArrayList<>();

        // Add edges
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 1));
        edges.add(new Edge(2, 1, 2));
        edges.add(new Edge(1, 3, 1));
        edges.add(new Edge(2, 3, 5));
        edges.add(new Edge(3, 4, 3));

        BellmanFordAlgo obj = new BellmanFordAlgo();
        obj.bellmanFord(edges, numberOfVertex, 0);
    }
}