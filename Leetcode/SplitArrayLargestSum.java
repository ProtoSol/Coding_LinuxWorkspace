public class SplitArrayLargestSum {
    public static void main(String[] args) {
        // You can add your test cases here
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        Solution solution = new Solution();
        int result = solution.splitArray(nums, m);
        System.out.println("Minimum value of the maximum subarray sum: " + result);
    }

    static class Solution {
        public int splitArray(int[] nums, int m) {
            int start = 0;
            int end = 0;
            for (int i = 0; i < nums.length; i++) {
                start = Math.max(start, nums[i]); // This will contain the max item from the array.
                end += nums[i]; // Sum of the array as the end
            }

            // apply binary search
            while (start < end) {
                // try for the middle as the potential ans
                int mid = start + (end - start) / 2;

                // Calc the no. of pieces it can be divided into
                int sum = 0;
                int pieces = 1;
                for (int num : nums) {
                    if (sum + num > mid) {
                        // cannot be added to subarray
                        // if added and comes out equal to sum
                        sum = num;
                        pieces++;
                    } else {
                        sum += num;
                    }
                }

                if (pieces > m) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            return end;
        }
    }
}