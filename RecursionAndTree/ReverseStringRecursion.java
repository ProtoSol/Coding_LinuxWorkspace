package RecursionAndTree;

public class ReverseStringRecursion {
    static String reverseString(String str){
        if(str.length() == 0){
            return"";
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Pranshu"));
    }
}
