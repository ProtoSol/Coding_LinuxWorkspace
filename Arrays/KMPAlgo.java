public class KMPAlgo {
    // This Algo stands for Knuth Morris Pratt Algorithm
    // This method is for Pattern Matching

    public static void main(String[] args) {
        String text = "abxabcabcabz";
        String pattern = "abcabz";

        int patternLenght = pattern.length();

        int[] lps = new int[patternLenght];
        lps[0] = 0; // Because No prefix initially

        int length = 0;
        int i = 1;

        // Filling the LPS array
        while (i < patternLenght) {
            if(pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if(length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Performing the Pattern Matching
        i = 0; // text
        int j = 0; // pattern
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if(j == patternLenght) {
                System.out.println("Found at : " + (i - j));
                j = lps[j - 1];
            }
            else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                }
                else{
                    i++;
                }
            }
        }

    }
}
