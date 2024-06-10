public class PrefixSum {
    
    // Prefix is a form of Pre Processing.
    // This helps in faster Processing and helps in reducing the time complexity
    // But at the cost of space Complexity.

    // It is used on the Arrays of Number

    // It is used to give the answer to the Range Sum query.

    public static void main(String[] args) {
        // Initializing
        int arr[] = {1,6,3,2,7,2};
        int queries[][] = {{0,3},{2,5},{2,4}};
        int prefix[] = new int[arr.length]; 
        prefix[0] = arr[0];

        // Fill the prefix array
        for(int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        // Print the Original Array
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Print the Prefix Array
        for(int i = 0; i < prefix.length; i++) {
            System.out.print(prefix[i] + " ");
        }
        System.out.println();

        // Perform the Queries
        for(int i = 0; i < queries.length; i++) {
            int lowerBound = queries[i][0];
            int upperBound = queries[i][1];
            int sumPrefix = prefix[upperBound] - prefix[lowerBound] + arr[lowerBound];
            System.out.println("Sum of elements between " + lowerBound + " and " + upperBound + " is " + sumPrefix);
        }
    }
}