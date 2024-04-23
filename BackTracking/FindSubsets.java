import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubsets {
    // Need To fix the Main method for the Execution.
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums); // Change method name to match Solution class
        System.out.println("Subsets of " + Arrays.toString(nums) + ":");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) { // Change method name to match main method
        List<Integer> smallList = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        int index = 0;
        helper(nums, smallList, finalList, index);
        return finalList;
    }

    void helper(int[] nums, List<Integer> smallList, List<List<Integer>> finalList, int index) {
        if (index == nums.length) { // Corrected condition
            finalList.add(new ArrayList<>(smallList));
            return;
        }

        finalList.add(new ArrayList<>(smallList));

        for (int i = index; i < nums.length; i++) {
            if (!smallList.contains(nums[i])) {
                smallList.add(nums[i]);
                helper(nums, smallList, finalList, i + 1);
                smallList.remove(smallList.size() - 1);
            }
        }
    }
}