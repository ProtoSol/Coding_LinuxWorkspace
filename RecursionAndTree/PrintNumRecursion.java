package RecursionAndTree;

public class PrintNumRecursion {
    public static void main(String[] args) {
        printNum(5);
        printDigits(12345);
    }

    private static void printDigits(int num) {
        if (num == 0){
            return;
        }
        printDigits(num/10);
        System.out.println(num%10);
    }

    private static void printNum(int num){
        if (num == 0){
            return;
        }
        printNum(num - 1);
        System.out.println(num);
    }
}
