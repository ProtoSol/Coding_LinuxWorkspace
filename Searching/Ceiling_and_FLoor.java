package Searching;

import java.util.Arrays;

public class Ceiling_and_FLoor {

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,8,9,12,15,25,38};
        int target = 16;
        System.out.println("In the Array " + Arrays.toString(arr) + ":");
        System.out.println("Floor value for the target "+ target + " is: " + floor(arr,target));
        System.out.println("Ceiling value for the target "+ target + " is: " + ceiling(arr,target));
    }

    // The case comes out greater than largest in the ceil, and taget comes out lower than smallest in floor.
    // we will add edge case.

    static int floor(int[] arr, int target) {

        if (target < arr[0]) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arr[end];
    }

    static int ceiling(int[] arr, int target) {

        if (target > arr[arr.length - 1]) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arr[start];
    }
}
