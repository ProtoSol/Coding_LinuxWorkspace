class Q75SortColor {

    // Three Pointer

    public static void sortColors(int[] nums) {
        // Initialize three pointers
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        // Traverse the array
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Swap elements at two indices in the array
    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}