package Technical_Training;

//Pascal Case is Used for writing convention.

public class WaysToAssign_TT {
    public static void main(String[] args) {
        // Ways to make a variable

        // Explicit
        int a = 10;

        // Implicit
        var b = 10;
        // This works only in local environment.

        final int MAX = 100;
        // This will become Constant.
        // Should write in Capitals.
        // Cannot update this, and this is good for Documentation purpose.

        System.out.println(a + " " + b + " " + MAX);
    }
}
