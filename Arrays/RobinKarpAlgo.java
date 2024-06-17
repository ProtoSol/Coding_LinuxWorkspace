public class RobinKarpAlgo {
    // The Algorithm for Rabin-Karp Algorithm to perform Pattern Checking

    public static boolean robinKarp(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        int p = 0; // Pointer for text
        int t = 0; // Pointer for pattern
        long hashPattern = 0;
        long hashText = 0;
        long power = 1; // Calculate the value of 26^(n-1) to use for rolling hash calculation

        // Calculate the value of 26^(n-1)
        for (int i = 0; i < n - 1; i++) {
            power = power * 26;
        }

        // Calculate the hash value of the pattern
        for (int i = 0; i < n; i++) {
            hashPattern = (hashPattern * 26 + pattern.charAt(i) - 'a') % (int)Math.pow(26, n);
        }

        // Calculate the hash value of the first substring of text
        for (int i = 0; i < n; i++) {
            hashText = (hashText * 26 + text.charAt(i) - 'a') % (int)Math.pow(26, n);
        }

        // Slide the pattern on top of the text, pick one letter each time
        for (int i = n; i < m; i++) {
            // Check if the hash values match
            if (hashPattern == hashText) {
                // Additional check for matching characters
                if (text.substring(i - n, i).equals(pattern)) {
                    return true;
                }
            }

            // Remove leading letter from hashText and add the new letter
            hashText = (((hashText - (text.charAt(i - n) - 'a') * power) * 26) + (text.charAt(i) - 'a')) % (int)Math.pow(26, n);
        }

        // Check for the last window
        if (hashPattern == hashText && text.substring(m - n).equals(pattern)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String text = "abcdefabcd";
        String pattern = "abcd";
        System.out.println(robinKarp(text, pattern));
    }
}