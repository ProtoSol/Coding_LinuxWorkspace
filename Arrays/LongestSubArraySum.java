public class LongestSubArraySum {
    
    // Find the Lenght of Longest Sub Array Sum
    public static void main(String[] args) {
        int arr[] = {3,1,-2,7,4,2,4,1,5};
        int k = 8;
        // Maintain 2 pointer
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;
        // Move to the right till the given constraint is valid.
        for(int right = 0; right < arr.length; right++){
            // If constraint is not valid keep removing the left added values
            currentSum += arr[right];
            while (currentSum > k) {
                currentSum -= arr[left];
                left ++;
            }
            maxSum = Math.max(maxSum, right - left + 1);
        }
        System.out.println("Longest Sub Array Sum is " + maxSum);
    }
}
