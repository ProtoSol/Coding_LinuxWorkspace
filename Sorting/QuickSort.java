package Sorting;

import java.util.Arrays;

public class QuickSort {

    // Swap element function
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // QuickSort function
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the partition index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function
    static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = arr[high];
        
        // Index of smaller element
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        swap(arr, i + 1, high);

        return i + 1;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        // Initializing the Function
        quickSort(arr, 0, arr.length - 1);
        // Print the Sorted Array
        System.out.println(Arrays.toString(arr));
    }
}