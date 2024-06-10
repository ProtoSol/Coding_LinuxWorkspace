public class FindSumSubLenghtK {
    
    // Given int array with int k, find the sum of the subarray with the largest sum whose length is k

    public static void main(String[] args) {

        // Test Case
        int arr[] = {3,1,-2,7,4,2,4,1,5};
        int k = 8;

        // Call the function
        findSumSubLenghtK(arr, k);

    }

    public static void findSumSubLenghtK(int[] arr, int k) {

        // Base Condition
        if(k > arr.length) {
            System.out.println("Not Found");
        }

        // Making the Window
        int pointer = k;
        int sum = 0;

        // Find the sum
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }

        // Initializing the Result
        int max = sum;

        // Now we will start the loop
        for(; pointer < arr.length; pointer++) {
            sum += arr[pointer] - arr[pointer - k];
            max = Math.max(max, sum);
        }

        // Print the result
        System.out.println(max);
    }
}