package RecursionAndTree;

public class SearchAndReplaceWordRecursion {
    private static String searchAndReplaceWordRecursive(String sentence, String replace, String replaceWith){
        String[] sentenceArray = sentence.split(" ");
        return  searchAndReplaceWordRecursiveHelper(sentenceArray, replace, replaceWith, 0);
    }

    private static String searchAndReplaceWordRecursiveHelper(String[] arr, String replace, String replaceWith, int n) {
        if (n == arr.length) {
            return "";
        }
        String currentWord = arr[n];
        if (currentWord.equals(replace)) {
            currentWord = replaceWith;
        }
        return currentWord + " " + searchAndReplaceWordRecursiveHelper(arr, replace, replaceWith, n + 1);
    }

    public static void main(String[] args) {
        String ques = "Hi Pranshi Hi There";
        System.out.println(searchAndReplaceWordRecursive(ques, "Hi", "Hello"));
    }
}
