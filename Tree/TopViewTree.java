package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewTree {
    
    static class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.hd = hd;
            this.node = node;
        }
    }
    
    static class Solution {
        // Function to return a list of nodes visible from the top view
        // from left to right in Binary Tree.
        static ArrayList<Integer> topView(Node root) {
            ArrayList<Integer> result = new ArrayList<>();
            Map<Integer, Node> map = new TreeMap<>();
            if (root == null) {
                return result;
            }
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(root, 0));
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                // Top view maintained here
                if(!map.containsKey(pair.hd)) {
                    map.put(pair.hd, pair.node);
                }
                if(pair.node.left != null)  queue.offer(new Pair(pair.node.left, pair.hd - 1));
                if(pair.node.right != null)  queue.offer(new Pair(pair.node.right, pair.hd + 1));
            }
            // Fill the List with HD negative to Positive
            for(Map.Entry<Integer, Node> m : map.entrySet()) {
                result.add(m.getValue().data);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        // Call the topView method
        ArrayList<Integer> topViewResult = Solution.topView(root);

        // Print the result
        System.out.println("Top view of the binary tree:");
        for (int value : topViewResult) {
            System.out.print(value + " ");
        }
    }
}