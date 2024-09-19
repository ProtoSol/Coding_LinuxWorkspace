// Link to the question: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

public class Q1283FindSmallest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        Solution obj = new Solution();
        System.out.println(obj.smallestDivisor(nums, threshold));
    }
}

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        
        int start = 1;
        int end = max;
        int ans = max;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum <= threshold) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return ans;
    }
}
