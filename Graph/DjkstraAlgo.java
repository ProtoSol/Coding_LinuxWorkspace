package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Edge{
    int target;
    int weight;
    Edge(int target, int weight){
        this.target = target;
        this.weight = weight;
    }
}

// Node => Vertex
class Node{
    int value;
    int distance;
    Node(int value, int distance){
        this.value = value;
        this.distance = distance;
    }
}

public class DjkstraAlgo {

    void spg(List<List<Edge>> graph, int source){
        int numberOfVertex = graph.size();
        // Maintain an Array for distance
        int[] distance = new int[numberOfVertex];

        // Fill the Distance to Infinity
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Put the Source Values
        distance[source] = 0;

        // Create a Priority Queue
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node->node.distance));
        
        // Start adding the Nodes
        queue.add(new Node(source, 0));

        while (!queue.isEmpty()){
            // get the smaller distance from the queue.
            Node node = queue.poll();
            int vertex = node.value;
            // Get the Neighbours of vertex
            for(Edge edge : graph.get(vertex)){
                int vertex2 = edge.target;
                int weight = edge.weight;
                if (distance[vertex] + weight < distance[vertex2]) {
                    distance[vertex2] = distance[vertex] + weight;
                    queue.add(new Node(vertex2, distance[vertex2]));
                }
            }
        }

        printSVG(distance);
    }

    void printSVG(int[] distance){
        // Now we use the for loop to print out the distance from the source
        for(int i = 0; i < distance.length; i++){
            System.out.println("Distance from source to " + i + " is " + distance[i]);
        }
    }
    
    public static void main(String[] args) {
        int numberOfVertex = 5;
        // To represent in a graph form
        // Put the values in a Adjacency List

        List<List<Edge>> graph = new ArrayList<>();

        // First build the vertex with empty neighbours
        for(int i = 0; i < numberOfVertex; i++){
            graph.add(new ArrayList<>());
        }
        // Build Connections
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));
        
        DjkstraAlgo obj = new DjkstraAlgo();
        obj.spg(graph, 0);
    }

}
