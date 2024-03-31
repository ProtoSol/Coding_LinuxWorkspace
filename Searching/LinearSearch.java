package Searching;

public class LinearSearch {
    // Searching for the element in a Linear fashion across the given list.

    // returns the index of the element to be found.
    // If not found we will return -1.

    static int linearSearch(int[] array, int size, int key){

        if(size == 0){
            return -1;
        }

        for(int index = 0; index < size; index++){
            if (array[index] == key){
                return index;
            }
        }
        return -1;

    }

    // The same logic can be applied to the Strings but
    // Do remember the functions to be used for String

    static boolean searchString(String str, char target){

        if(str.length() == 0){
            return false;
        }

        // for(int i = 0; i < str.length(); i++){
        //     if(target == str.charAt(i)){
        //         return true;
        //     }
        // }


        // Advanced for loop
        for(char ch : str.toCharArray()){
            if(ch == target){
                return true;
            }
        }

        return false;
    }
    

    // Searching in a given range

    static int searchRange(int[] arr, int key, int start, int end){
        if(arr.length == 0){
            return -1;
        }

        for(int index = start; index < end; index++){
            if (arr[index] == key){
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,3,2,1};
        System.out.println("Element found at Index : " + linearSearch(arr, arr.length, 3));
        String name = "Pranshu";
        char toSearch = 'u';
        System.out.println("Is present? " + searchString(name, toSearch));
    }
}
