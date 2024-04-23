package Recursion;

public class ArmstrongNumberRecursion {
    public static void main(String[] args) {
        // Void function type
        armstrongNumberRec(153, 0, 153);
        // Int return type
        int[] result = armstrongNumberRec2(153,0,153);
        if (result[0] == result[1]) {
            System.out.println("Is an Armstrong Number");
        } else {
            System.out.println("Is not an Armstrong Number");
        }
    }

    // Void
    private static boolean armstrongNumberRec(int num, int result, int check){
        if (num == 0) {
            if (check == result) {
                System.out.println("It is an Armstrong Number");
                return true;
            } else {
                System.out.println("Is not an Armstrong Number");
                return false;
            }
        } else {
            int lastDigitCube = (num % 10) * (num % 10) * (num % 10);
            return armstrongNumberRec(num / 10, result + lastDigitCube, check);
        }
    }

    // Int return
    private static int[] armstrongNumberRec2(int num, int result, int check){
        if (num == 0) {
            return new int[] {result, check};
        } else {
            int lastDigitCube = (num % 10) * (num % 10) * (num % 10);
            return armstrongNumberRec2(num / 10, result + lastDigitCube, check);
        }
    }
}
