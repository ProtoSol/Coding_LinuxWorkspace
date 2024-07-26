package Dynamic_Programming;

import java.util.HashMap;

public class RollDiceGame {

    // This is the Recursive Solution that has the time complexity O(6^n)
    static int countWays (int startValue, int endValue){
        // Base Case;
        if (startValue == endValue) return 1;
        if(startValue > endValue) return 0;

        int count = 0;
        for(int dice = 1; dice <= 6; dice++){
            count = count + countWays(startValue + dice, endValue);
        }
        return count;
    }
    // This solution is not optimized at all.

    // Thus we use the Dynamic Programming approach to this question
    // Top Down Approach
    static HashMap<Integer,Integer> memo = new HashMap<>();
    static int countWaysTD (int startValue, int endValue){
        // Base Case;
        if (startValue == endValue) return 1;
        if(startValue > endValue) return 0;
        if(memo.get(startValue) != null){
            return memo.get(startValue);
        }

        int count = 0;
        for(int dice = 1; dice <= 6; dice++){
            count = count + countWaysTD(startValue + dice, endValue);
        }
        memo.put(startValue, count);
        return count;
    }

    // Bottom Up Approach / Tabulation Approach
    static int countWaysBU (int startValue, int endValue){
        int cache[] = new int[endValue + 1];
        cache[endValue] = 1;
        for(int i = endValue - 1; i >= startValue; i--){
            int count = 0;
            for(int dice = 1; dice <= 6 && dice + i < cache.length; dice++){
                count = count + cache[dice + i];
            }
            cache[i] = count;
        }
        return cache[startValue];
    }

    public static void main(String[] args) {
        int count = countWaysBU(0, 10);
        System.out.println(count);
    }
}
