package Recursion;

public class SearchAndReplaceCharRecursive {
    static String searchAndReplaceCharRecursive(String str, char key, char replace){
        if(str.length() == 0){
            return"";
        }
        if (str.charAt(0) == key) {
            return replace + searchAndReplaceCharRecursive(str.substring(1), key, replace);
        }
        return str.charAt(0) + searchAndReplaceCharRecursive(str.substring(1), key, replace);
    }

    public static void main(String[] args) {
        System.out.println(searchAndReplaceCharRecursive("Pranshu",'u', 'x'));
    }
}
