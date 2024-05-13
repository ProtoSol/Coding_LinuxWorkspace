package RecursionAndTree;

public class RemoveConsecutiveDuplicateRecursion {
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicateRecursion("AAAABBBCCDC"));
    }

    // Unoptimized and Complicated
    // private static String removeConsecutiveDuplicateRecursion(String str) {
    //     if (str.length() == 0) {
    //         return "";
    //     }
    //     String result = removeConsecutiveDuplicateRecursion(str.substring(1));
    //     if (result.isEmpty()) {
    //         return str.charAt(0) + "";
    //     }
    //     if (str.charAt(0) == result.charAt(0)) {
    //         return result;
    //     }
    //     return str.charAt(0) + result;
    // }

    // Better Solution
    private static String removeConsecutiveDuplicateRecursion(String str){
        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            return removeConsecutiveDuplicateRecursion(str.substring(1));
        } else{
            return str.charAt(0) + removeConsecutiveDuplicateRecursion(str.substring(1));
        }
    }
}
