package Searching;

import javax.sound.midi.Track;

public class BinarySeach {

    // This is used for a sorted array. [Ascending or descending]
    // First we find the sorted array
    // Then the middle element is used for comparision.
    // If less we move to right side, else we move to the left side.
    // the process is repeated till the element is found.
    // O(nlogn)

    // In the case where we dont know the order of the array, we apply Order genostic Binary Search.
    // We compare the starting and the ending element to find the order of the sorting.

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,8};
        int ans = binarySearch(arr, 3);
        System.out.println(ans+1);

        int[] arr2 = {9,8,7,6,5,4,3,2,1};
        int ans2 = orderGenosticBinarySearch(arr2, 3);
        System.out.println(ans2+1);
    }

    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // int mid = (start + end) / 2;
            // The above line will create a problem as it has a based size.
            // It might be possible that it may go out of bound / out of size.

            // better way
            int mid = start + (end - start) / 2;
            
            // Base conditions
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]){
                start = mid + 1;
            } else {
                // return the answer
                return mid;
            }
        }
        return -1;
    }

    static int orderGenosticBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        // Find the order of the Sorting
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            // int mid = (start + end) / 2;
            // The above line will create a problem as it has a based size.
            // It might be possible that it may go out of bound / out of size.

            // better way
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            
            if(isAsc){
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            
        }
        return -1;
    }
}
