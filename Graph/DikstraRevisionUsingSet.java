package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DikstraRevisionUsingSet {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            int[] ptr = Solution.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}

//User function Template for Java

class Pair {
    int toNode, distance;
    public Pair(int v, int wt) {
        this.toNode = v;
        this.distance = wt;
    }
}

class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Use a set to store unvisited nodes
        Set<Integer> unvisited = new HashSet<>();
        // Make the distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // Make the source node distance 0
        dist[S] = 0;
        // Add all nodes to the unvisited set
        for (int i = 0; i < V; i++) {
            unvisited.add(i);
        }
        // Loop until the unvisited set is empty
        while (!unvisited.isEmpty()) {
            // Find the node with the smallest distance
            int minDist = Integer.MAX_VALUE;
            int node = -1;
            for (int u : unvisited) {
                if (dist[u] < minDist) {
                    minDist = dist[u];
                    node = u;
                }
            }
            // If node is not found, break (remaining nodes are inaccessible)
            if (node == -1) {
                break;
            }
            // Remove the selected node from the unvisited set
            unvisited.remove(node);
            // Traverse through adjacent nodes
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).get(0);
                int w = adj.get(node).get(i).get(1);
                
                if (unvisited.contains(v) && dist[node] + w < dist[v]) {
                    dist[v] = dist[node] + w;
                }
            }
        }
        // Return the distance array
        return dist;
    }
}
