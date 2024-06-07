public class MissingNumberInArray {
    // Finding the Missing number in an Array
    // https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1

    private void findMissingNumber(int[] arr){
        int n = arr.length + 1; // total number of elements in the array
        int sum = n * (n + 1) / 2; // sum of first
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
        } // missing number is the difference between the sum and the other elements from the List
        System.out.println("The missing number is: " + sum);
    }

    public static void main(String[] args) {
        MissingNumberInArray obj = new MissingNumberInArray();
        int[] arr = {1, 2, 3, 5, 6};
        obj.findMissingNumber(arr);
    }
}
