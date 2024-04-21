package Recursion;

public class PrintAdjacentStarRecursion {
    public static void main(String[] args) {
        System.out.println("Original String AABBBBC, Output is :" + adjStar("AABBBBC"));
    }
    static String adjStar(String str){
        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + "*" + adjStar(str.substring(1));
        }
        else {
            return str.charAt(0) + adjStar(str.substring(1));
        }
    }
}
