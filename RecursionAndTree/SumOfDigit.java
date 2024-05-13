package RecursionAndTree;

public class SumOfDigit {
    public static void main(String[] args) {
        sumOfDigit(123,0);
        System.out.println("Sum of digits in num 1234 : " + sumOfDigit2(1234, 0));
    }

    // With void method.
    private static void sumOfDigit(int n, int sum){
        if(n == 0){
            System.out.println(sum);
            return;
        }
        sumOfDigit(n/10, sum + n%10);
    }

    // With return type int
    private static int sumOfDigit2(int n, int sum){
        if(n == 0){
            return sum;
        }
        return sumOfDigit2(n/10, sum + n%10);
    }
}
