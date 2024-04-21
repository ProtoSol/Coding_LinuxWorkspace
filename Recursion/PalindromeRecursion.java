package Recursion;

public class PalindromeRecursion {
    public static void main(String[] args) {
        if(palindromeRec(1213,0,121)){
            System.out.println("Is a Palindrome Number");
        } else {
            System.out.println("Is not a Palindrome Number");
        }
    }

    private static boolean palindromeRec(int num, int rev, int check) {
        if (num == 0) {
            return (check == rev);
        }
        return palindromeRec(num / 10, rev*10 + num %10, check);
    }
}
