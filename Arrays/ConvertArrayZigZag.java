import java.util.Arrays;

public class ConvertArrayZigZag {
    public static void main(String[] args) {
        int arr[] = {4, 3, 7, 8, 6, 2, 1};

        // Output should be 3,7,4,8,2,6,1
        
        boolean flag = true;

        // Iterate through the array to convert it to a zigzag pattern
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag) {
                // If the current element is greater than the next element, swap them
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                // If the current element is less than the next element, swap them
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag; // Toggle the flag for the next iteration
        }

        System.out.println(Arrays.toString(arr));
    }
}