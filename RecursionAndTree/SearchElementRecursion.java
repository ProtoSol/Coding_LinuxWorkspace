package RecursionAndTree;

import java.util.Arrays;

public class SearchElementRecursion {
    public static void main(String[] args) {
        int[] arr = new int[] {10,20,30,40,50,20,20};
        // Void Function
        searchArr(arr, 0, 30);

        // Boolean Function
        if (searchArr2(arr,0,30)) {
            System.out.println("Found the Element");
        } else {
            System.out.println("the Element not Found");
        }

        System.out.println("The Element found at Locations: " + Arrays.toString(findOccur(arr, 0, 20, 0)) );
    }

    // Boolean Function
    private static boolean searchArr2(int[] arr, int n, int key) {
        // Base Case
        if (n == arr.length) {
            return false;
        }
        // Working Function
        if(arr[n] == key){
            return true;
        }
        return searchArr2(arr, n+1, key);
    }

    // Void Function
    private static void searchArr(int[] arr, int n, int key) {
        // Base Case
        if (n == arr.length) {
            return;
        }
        // Working Function
        if(arr[n] == key){
            System.out.println("Found the Element");
            return;
        }
        searchArr(arr, n+1, key);
    }

    // Array Function
    private static int[] findOccur(int[] arr, int index, int key, int count){
        if(index == arr.length){
            int[] result = new int[count];
            return result;
        }
        if (arr[index] == key) {
            count++;
        }
        int[] result = findOccur(arr, index+1, key, count);
        if (arr[index] == key) {
            result[count - 1] = index;
        }
        return result;
    }
}
