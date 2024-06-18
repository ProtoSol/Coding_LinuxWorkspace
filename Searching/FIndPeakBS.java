package Searching;

public class FIndPeakBS {
    // This function returns the index of a peak element
    // in a given array arr[].
    static int findPeakElement(int[] arr) {
        // find the maximum element in the array
        int maxElement = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
                maxIndex = i;
            }
        }

        // now use binary search to find the peak element
        int start = 0, end = maxIndex;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] < arr[mid - 1])
                return mid - 1;
            else if (arr[mid] > arr[mid - 1])
                start = mid + 1;
            else
                end = mid - 1;
        }

        // we will not reach here as we will get the peak element
        // in the previous step
        return -1;
    }
}
