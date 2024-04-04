package Technical_Training;

public class MazePath {
    // All methods are Brute Force
    // N x N maze
    // 1 Step can be taken
        // either go left or right (horizontal or vertical)
    // output should be what are the possible steps to take, for reaching the home.

    // P    -   -
    // -    -   -
    // -    -   H

    // Posibilities-
        // HHVV
        // VVHH
        // HVHV

    // Tree Signature
    static void mazePath(int row, int col, int rowEnd, int colEnd, String result){
        // Base case
        if (row == rowEnd+1) {
            return;
        }
        if (col == colEnd+1){
            return;
        }
        if(row == rowEnd && col == colEnd){
            System.out.println(result);
            return;
        }

        // Working Case
        // Small Problem going Down
        mazePath(row + 1, col, rowEnd, colEnd, result+"V");
        // Small Problem going Right
        mazePath(row, col+1, rowEnd, colEnd, result+"H");
    }

    public static void main(String[] args) {
        mazePath(0, 0, 2, 2, "");
    }
}
