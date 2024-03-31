package Sorting;

import java.util.Arrays;

public class InsertionSort {

    static void swap(int[] arr, int a, int b){
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
    
    static void insertion(int[] arr, int n){
        for(int i = 0; i < n - 1; i++){
            for(int j = i+1; j > 0; j--){
                if (arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,4,1,2};
        insertion(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
