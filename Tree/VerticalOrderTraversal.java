package Tree;

import java.util.*;

public class VerticalOrderTraversal {

    // The Recursive version is done on the Leetcode platform.
    
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
        // Function to return a list of nodes in vertical order traversal
        static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            
            TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(root, 0));
            
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                Node node = pair.node;
                int hd = pair.hd;
                
                if (!map.containsKey(hd)) {
                    map.put(hd, new ArrayList<>());
                }
                map.get(hd).add(node.data);
                
                if (node.left != null) {
                    queue.offer(new Pair(node.left, hd - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, hd + 1));
                }
            }
            
            result.addAll(map.values());
            return result;
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Call the verticalOrder method
        ArrayList<ArrayList<Integer>> verticalOrderResult = Solution.verticalOrder(root);

        // Print the result
        System.out.println("Vertical order traversal of the binary tree:");
        for (ArrayList<Integer> level : verticalOrderResult) {
            System.out.println(level);
        }
    }
}