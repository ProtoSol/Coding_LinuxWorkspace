package Leetcode;

public class Q1482MinNumberOfDays {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        int result = solution.minDays(bloomDay, m, k);
        System.out.println(result);
    }
}

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(numberOfBouquets(bloomDay, mid, k) >= m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int numberOfBouquets(int[] bloomDay, int day, int k) {
        int numberOfBoq = 0;
        int cnt = 0;
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= day) {
                cnt++;
            } else {
                numberOfBoq += (cnt/k);
                cnt = 0;
            }
        }
        numberOfBoq += (cnt/k);
        return numberOfBoq;
    }
}

