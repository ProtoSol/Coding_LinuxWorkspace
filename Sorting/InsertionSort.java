package Sorting;

import java.util.Arrays;

public class InsertionSort {

    static void swap(int[] arr, int a, int b){
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    static void insertion(int[] arr, int n){
        for(int i = 1; i < n; i++){
            int value = arr[i];
            // Previous value
            int j = i - 1;
            while(j >= 0 && arr[j] > value){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,4,1,2};
        insertion(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
