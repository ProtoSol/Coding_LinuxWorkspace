//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class CheapestFlightKStops {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Pair{
    int node;
    int cost;
    Pair(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}

class Tuple{
    int node;
    int cost;
    int stops;
    Tuple(int node, int cost, int stops){
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
}

class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        // BFS setup
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(src, 0, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int node = current.node;
            int cost = current.cost;
            int stops = current.stops;

            // If we exceed the allowed number of stops, skip further processing
            if (stops > k) continue;

            // Explore neighbors
            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int nextCost = neighbor.cost;

                // If a cheaper flight is found, update the distance and add to the queue
                if (cost + nextCost < dist[nextNode]) {
                    dist[nextNode] = cost + nextCost;
                    queue.add(new Tuple(nextNode, cost + nextCost, stops + 1));
                }
            }
        }

        // Return the result
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}