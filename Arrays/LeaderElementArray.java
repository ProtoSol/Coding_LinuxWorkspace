import java.util.ArrayList;
import java.util.Collections;

public class LeaderElementArray {
    public static void main(String[] args) {
        int arr[] = {16,17,4,3,5,2};
        
        // Initialize variables to store the leader element and the list of leaders
        int leader = 0;
        ArrayList<Integer> leaders = new ArrayList<Integer>();
        
        // Iterate through the array in reverse order to find the leader elements
        for(int i = arr.length - 1; i >=0; i--){
            // Check if the current element is greater than or equal to the leader
            if (arr[i] >= leader) {
                // Update the leader and add it to the list of leaders
                leader = arr[i];
                leaders.add(leader);
            }
        }
        
        // Reverse the list of leaders to maintain the original order
        Collections.reverse(leaders);
        
        // Print the list of leader elements
        System.out.println(leaders);
    }
}