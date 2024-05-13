package RecursionAndTree;

public class PatternRecursive {
    public static void main(String[] args) {
        printLine(5);
    }
    private static void printLine(int n){
        if(n == 0){
            return;
        }
        printLine(n-1);
        printStar(n);
        System.out.println();
    }
    private static void printStar(int n){
        if (n == 0) {
            return;
        }
        System.out.print("*");
        printStar(n-1);
    }
}
