import java.sql.Array;
import java.util.Arrays;

public class ArraysContinuation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(arr.toString());
        change(arr);
        System.out.println(arr.toString());
    }

    static void change(int[] arr){
        arr[0] = 99;
    }

    // As we can see the value of the arrays was changed directly.
    // Without any return values.
    // Strings are immutable and Arrays are mutable in nature.
}
