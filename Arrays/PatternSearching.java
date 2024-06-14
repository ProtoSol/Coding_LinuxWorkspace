public class PatternSearching {
    // There are many ways to perform pattern searching

        // Naive Pattern Searching Algorithm
        // Time Complexity: O(n^2)
        // Space Complexity: O(1)
        // Slide Pattern one by one over the given text
            // if the pattern matches
            // then check for next pattern
            // else move to next pattern
        
        // Works one two pointer approach


    // This is a type of brute force approach
    public static void main(String[] args) {
        String text = "abcdefabctypabc";
        String pattern = "abc";
        // Slide the pattern on top of the text, pick one letter each time
        for(int i = 0; i <= text.length() - pattern.length(); i++) {
            int j;
            for(j = 0; j < pattern.length(); j++) {
                if(text.charAt(i + j) != pattern.charAt(j)){
                    break;
                }
            }
            if (j == pattern.length()) {
                System.out.println("Found at : " + i);
            }
        }
    }
}
