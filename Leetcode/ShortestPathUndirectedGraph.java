import java.io.*;
import java.util.*;

public class ShortestPathUndirectedGraph {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends

class Pair {
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Create the adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // Change m to n for correct indexing
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        // Priority Queue for Dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        
        // Distance and parent arrays
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        // Initialize the source node (node 1)
        dist[1] = 0;
        pq.add(new Pair(0, 1));
        
        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int node = it.second;
            int weight = it.first;

            for (Pair iter : adj.get(node)) {
                int next = iter.first;
                int nextWeight = iter.second;
                if (dist[next] > dist[node] + nextWeight) {
                    dist[next] = dist[node] + nextWeight;
                    parent[next] = node;
                    pq.add(new Pair(dist[next], next));
                }
            }
        }

        // Extract the shortest path from source to node n
        List<Integer> res = new ArrayList<>();
        int node = n;
        
        if (dist[n] == Integer.MAX_VALUE) {
            res.add(-1); // If there's no path from source to destination
            return res;
        }

        while (parent[node] != node) {
            res.add(node);
            node = parent[node];
        }
        res.add(1); // Adding the source node at the end

        // The path is constructed in reverse order, so we need to reverse it
        Collections.reverse(res);
        return res;
    }
}