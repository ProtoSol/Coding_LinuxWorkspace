package Dynamic_Programming;

public class DPRevision {
    // To solve the problem of Recurrence relation (Repeating Sub Problem)
    // Thus we use the Memoization Technique for that.

    // The famous example for this is the Fibonacci Sequence.

    public static void main(String[] args) {
        int n = 9;  // Calculate the 9th Fibonacci number

        // Takes too much computation time.
        System.out.println("Fibonacci using recursion: " + fib(n));

        // Now using the Memoization Technique
        // We will use 1D array
        int[] memo = new int[n + 1];
        System.out.println("Fibonacci using memoization: " + fibMemo(n, memo));
        
        // Now we perform the problem using Tabulation Technique
        System.out.println("Fibonacci using tabulation: " + fibTab(n));
    }

    // Simple recursive approach (inefficient due to repeated subproblems)
    private static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // Optimized approach using memoization (efficient)
    private static int fibMemo(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] == 0) {  // Memoization to avoid recalculating subproblems
            memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        }
        return memo[n];
    }

    // Tabulation Technique
    private static int fibTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
