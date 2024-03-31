package Searching;

public class LinearSearch2D {
    public static void main(String[] args) {
        int [][] arr = {
            {23,4,1},
            {18,12,3,9},
            {78,99,34,56},
            {18,12}
        };
        int target = 34;
        search2D(arr, target);
    }


    // 
    private static void search2D(int[][] arr, int target) {

        for(int row = 0; row < arr.length; row++){
            for(int column = 0; column < arr[row].length; column++){
                if(arr[row][column] == target){
                    System.out.println("Located at Row: " + (row + 1)+ " and Column: " + (column + 1));
                    return;
                }
            }
        }
        System.out.println("Not present in the array");
    }
}
