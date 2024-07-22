package Graph;

/*
 * Disjoint Set -> Unconnected components of a Graph
 * 
 * This is also called Union Find Data Structure.
 * 
 * Working of Disjoint Set ->
 * 
 *      We have a Graph with different components. Then we get the Union of the components.
 *      ((0,1,2,3)(4,8)(5,6,7)) To (0,1)(0,2)(1,3)(4,8)(5,6)(5,7) with Union
 *      This can be used to find the relation for eg (1,5)(7,8) does not exists.
 * 
 * In Code ->
 *      
 *      Make an Array of the size equals to number of nodes.
 *      Fill the Array with the Numbers of the indexes.
 *      Replace the value in an index with it's parent value.
 *      This array can be used to answer the Intersection query.
 *      For Union we can replace other root with the node value.
 * 
 * There are two ways to implement Disjoint set ->
 *      1. Quick Find Way [Find O(1) Union O(N)]
 *      2. Quick Union Way [Union Time Complexity better than Find Time Complexity]
*/

// Quick Find Way Implementation
class UnionAndFind{
    // Constructor
    int[] arr;
    UnionAndFind(int size){
        arr = new int[size]; // By Default would be zero
        for(int  i = 0; i < size; i++){
            arr[i] = i;
        }
    }

    // Find Function O(1)
    int find(int val){
        return arr[val];
    }

    // Union Function O(N)
    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        // Stop when the roots are same
        // If the Roots are not same
        if(!isConnected(rootX, rootY)){
            // Go in loop and change the parent.
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == rootY){
                    arr[i] = rootX;
                }
            }
        }
    }

    // Function that checks for Connection between Nodes.
    boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}

class UnionBetterFindSlower{
    // Constructor
    int[] arr;
    UnionBetterFindSlower(int size){
        arr = new int[size]; // By Default would be zero
        for(int  i = 0; i < size; i++){
            arr[i] = i;
        }
    }

    // Find Function O(N) Slower
    int find(int val){
        while(val != arr[val]){
            val = arr[val];
        }
        return val;
    }

    // Union Function O(1) Faster
    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        // Stop when the roots are same
        // If the Roots are not same
        if(rootX != rootY){
            // Optimized the Code
            arr[rootY] = rootX;
        }
    }

    // Function that checks for Connection between Nodes.
    boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}

public class DisjointSet {
    public static void main(String[] args) {
        // Below Code for Quick Find Method
        // UnionAndFind obj = new UnionAndFind(7); // size + 1
        // obj.union(0, 1);
        // obj.union(1, 2);
        // obj.union(1 , 3);
        // obj.union(2, 5);
        // obj.union(2, 6);
        // obj.union(3, 4);

        // System.out.println(obj.isConnected(1, 5)); // Should Print true
        // System.out.println(obj.isConnected(5, 6)); // Should Print true
        // System.out.println(obj.isConnected(4, 5)); // Should Print true


        UnionBetterFindSlower obj2 = new UnionBetterFindSlower(7);
        obj2.union(0, 1);
        obj2.union(1, 2);
        obj2.union(1 , 3);
        obj2.union(2, 5);
        obj2.union(2, 6);
        obj2.union(3, 4);

        System.out.println(obj2.isConnected(1, 5)); // Should Print true
        System.out.println(obj2.isConnected(5, 6)); // Should Print true
        System.out.println(obj2.isConnected(4, 5)); // Should Print true
    }
}
