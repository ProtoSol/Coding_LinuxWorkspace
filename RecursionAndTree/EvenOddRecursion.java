package RecursionAndTree;

import java.util.Arrays;

public class EvenOddRecursion {

    public static void main(String[] args) {
        // We need to print the number of Even and Odd number present.
        countEvenOdd(11,0,0);

        int[] result = countEvenOdd2(11, 0, 0);
        System.out.println("Output from the Non Void Function : " + Arrays.toString(result));
    }
    
    private static int[] countEvenOdd2(int num, int evenCount, int oddCount) {
        if (num == 0) {           
            return new int[] {evenCount, oddCount};
        }
        if (num % 2 == 0) {
            return countEvenOdd2(num - 1, evenCount + 1, oddCount);
        } else {
            return countEvenOdd2(num - 1, evenCount, oddCount + 1);
        }
    }

    // Void method.
    private static void countEvenOdd(int num, int evenCount, int oddCount){
        if (num == 0) {
            System.out.println("Even number Count : " + evenCount);
            System.out.println("Odd number Count : " + oddCount);            
            return;
        }
        if (num % 2 == 0) {
            countEvenOdd(num - 1, evenCount + 1, oddCount);
        } else {
            countEvenOdd(num - 1, evenCount, oddCount + 1);
        }
    }

    // Return type Int we will use arr
}
