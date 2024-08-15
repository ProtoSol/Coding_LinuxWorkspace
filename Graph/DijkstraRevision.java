package Graph;
// Code is from the GFG Practice

//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class DijkstraRevision
{
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
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair{
    int toNode, distance; // v, wt
    public Pair(int v, int wt) {
        this.toNode = v;
        this.distance = wt;
    }
}

class Solution{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        // First make the min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);

        // make the distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // make the source node distance 0, and set the weight.
        dist[S] = 0;
        pq.add(new Pair(S, 0));
        
        // perform the bfs
        while (pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().toNode;
            pq.remove();
            // traverse through adj nodes
            for(int i = 0; i < adj.get(node).size(); i++){
                int v = adj.get(node).get(i).get(0);
                int w = adj.get(node).get(i).get(1);
                if(dis + w < dist[v]){
                    dist[v] = dis + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        
        // return the distance
        return dist;
    }
}