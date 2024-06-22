package Sorting;

import java.util.Arrays;

public class MergeSort {

    // Swap element function
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // Divide function
    static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        // Mid Index
        int mid = start + (end - start) / 2;
        // First Half
        mergeSort(arr, start, mid);
        // Second Half
        mergeSort(arr, mid + 1, end);
        // Merge Function
        merge(arr, start, mid, end);
    }

    // Combine and Conquer (Merge) function
    static void merge(int[] arr, int start, int mid, int end) {
        
        // Initialize the Left and Right Array
        int n1 = mid - start + 1;
        int[] leftArr = new int[n1];

        int n2 = end - mid;
        int[] rightArr = new int[n2];

        // Fill the Left Array
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[start + i];
        }

        // Fill the Right Array
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        // Merge the Left and Right Array
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        // Initializing the Function
        mergeSort(arr, 0, arr.length - 1);
        // Print the Sorted Array
        System.out.println(Arrays.toString(arr));
    }
}