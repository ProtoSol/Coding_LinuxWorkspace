import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionArray {
    public static void main(String[] args) {
        // 2d Arrays are same as Matrix
        /*
            1 2 3
            4 5 6
            7 8 9
        */

        // int[][] arr = new int[][]; // this produces an error.
        // int[][] arr = new int[5][]; // this will not produce any error.
        // int[][] arr = new int[5][5]; // this is also acceptable Of Course!
        // the number of rows is required to be initialized
        // the initialization of column is not necessary.

        // To store directly.
        
        // int[][] arr1 = {
        //     {1,2,3},
        //     {4,5,6},
        //     {7,8,9}
        // };

        // every single entity of multi dimension array is stored in the heap memory.
        // System.out.println(arr1.length); // This prints out only 3
        // System.out.println(arr1[0][2]); // this also prints out the value 3 using the indexing method

        // int[][] arr2 = {
        //     {1,2,3},
        //     {4,5,6},
        //     {7,8,9,10}
        // };
        // This is also acceptable as the arr2 contains three individual arrays.
        // This is the reason why it is not required to initialize the size of the columns.

        // Scanner Obj
        Scanner sc = new Scanner(System.in);

        // How we take the input for these array.

        int[][] arr2 = new int[3][3];

        for (int i = 0; i < arr2.length; i++) {
            // arr2.length gives out only the number of rows for no. of column we perform.
            for (int j = 0; j < arr2[i].length; j++) {
                // We take the length of individual array length as no of rows == no of arrays in the multidimensional array arr2.
                arr2[i][j] = sc.nextInt();
            }
        }
        sc.close();
        // Printing the multidimenstion array

        // for (int i = 0; i < arr2.length; i++) {
        //     // arr2.length gives out only the number of rows for no. of column we perform.
        //     for (int j = 0; j < arr2[i].length; j++) {
        //         // We take the length of individual array length as no of rows == no of arrays in the multidimensional array arr2.
        //         System.out.print(arr2[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // To print this using Arrays.toString() we will print using for loop.
        
        // for (int row = 0; row < arr2.length; row++){
        //     System.out.println(Arrays.toString(arr2[row]));
        // }
        // AS we know that the multidimension array just contains arrays that is equal to the row length
        // then we use this to print each array indivdualy.
        // Better version of the above function is as follows.
        for(int[] a : arr2){
            System.out.println(Arrays.toString(a));
        }

    }
}
