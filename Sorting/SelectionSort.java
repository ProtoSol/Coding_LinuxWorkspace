package Sorting;

import java.util.Arrays;

public class SelectionSort {
    static void selection(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int smallestIndex = i; // Assume the current element is the smallest
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j; // Update the index of the smallest element
                }
            }
            // Swap the current element with the smallest element
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,3,2,1,1,2,2};
        selection(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
