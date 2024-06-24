import java.util.Collections;
import java.util.HashMap;

/**
 * TopKFrequent
 */
public class TopKFrequent {

    public static void main(String[] args) {
        // We need to perform Hashing
        HashMap<Integer, Integer> map = new HashMap<>();
        // Compare the values of hashmap using the Collection library
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);
        map.put(9, 9);
        // Now sort the Hashmap using Collection Sort
        Collections.sort(1, (first, second)->
            first.getValue().equals(second.getValue())?second.getKey().compareTo(first.getKey()):
            second.getValue().compareTo(first.getValue()));
    }
    
}