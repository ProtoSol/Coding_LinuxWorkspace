public class Q238ProdExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Initialize the result array with 1
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Initialize right product as 1
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
        // Expected output: 24 12 8 6
    }
}
