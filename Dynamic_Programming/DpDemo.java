package Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

public class DpDemo {
    // Requires Problem Solving
    // There are certian common characteristics to these problems
        // Problem can be broken into overlapping sub problems
        // The smaller version of the original problem, that are repeated multiple times.
        // Optimal substructure -> To kill the overlapping sub-problem

    // Classical Problems
        // Fibonacci Number

    // Thus let's proceed to DP Fitment

    // This Recursive Soultion has the time complexity of O(n^2)
    static int fibo(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }

    // This runs recursively and consumes much calculation time due to double call and repetetive calculation
    // Thus we use the Dynamic Programming aspect

    // DP has two types of Approach
        // Top Down -> Recursive With Memoization (Caching the Recurring Answers)
        // Bottom Up -> Iterative

    // First Approach Top Down
    static Map<Integer, Integer> memo = new HashMap<>();
    static int fibdpTopDown(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        // Before Calc check if Present in memo
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int first = fibdpTopDown(n-1);
        int second = fibdpTopDown(n-2);
        int third  = first + second;
        memo.put(n,third); // Store in the Cache
        return memo.get(n); // Return the value from the Cache
    }


    // Bottom Up Approach, We need to use 1d Arrays or 2d Arrays O(n) / O(n^2), requires Recursion relation of the Problem.
    static int fibdpBottomUp(int n){
        // Base Case
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        // Take care of the Base Case
        // dp[0] = 0;
        dp[1] = 1;
        // Iterate through the array
        for(int i = 2; i <= n; i++){
            int firstTerm = dp[i-1];
            int secondTerm = dp[i-2];
            int thirdTerm = firstTerm + secondTerm;
            dp[i] = thirdTerm;
        }
        return dp[n];
    }

    // To Find the Optimal Sub Structure we required Reccurance relation.
    public static void main(String[] args) {
        // System.out.println(fibo(50)); // This is not computed due to O(n^2) Time complexity
        System.out.println(fibdpTopDown(30)); // Not above 30 as it goes out of range
    }
}
