package RecursionAndTree;

public class SortedArrayRecursion {
    public static void main(String[] args) {
        int[] arr = new int[] {10,20,30,40,50};
        // Void Function
        isSortedRec(arr, 1);
        // Boolean Function
        if (isSortedRec2(arr, 1)) {
            System.out.println("It is Sorted");
        } else {
            System.out.println("It is not Sorted");
        }
    }

    // Void
    private static void isSortedRec(int[] arr, int n){
        // Base Case
        if (n == arr.length) {
            System.out.println("It is Sorted");
            return;
        }
        // Condition
        if (arr[n-1] > arr[n]) {
            System.out.println("It is not Sorted");
            return;
        }
        // Recursion
        isSortedRec(arr, n+1);
    }

    // Boolean Return type
    private static boolean isSortedRec2(int[] arr, int n){
        // Base Case
        if (n == arr.length) {
            return true;
        }
        // Condition
        if (arr[n-1] > arr[n]) {
            return false;
        }
        // Recursion
        return isSortedRec2(arr, n+1);
    }
}
