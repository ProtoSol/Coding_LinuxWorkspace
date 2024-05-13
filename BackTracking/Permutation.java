import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public class Main {
    public void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = solution.permute(nums);
        System.out.println("Permutations of " + Arrays.toString(nums) + ":");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), finalList);
        return finalList;
    }
 
    private void backtrack(int[] nums, List<Integer> smallList, List<List<Integer>> finalList) {
        if (smallList.size() == nums.length) {
            finalList.add(new ArrayList<>(smallList));
            return;
        }
 
        for (int i = 0; i < nums.length; i++) {
            if (smallList.contains(nums[i])) {
                continue;
            }
            smallList.add(nums[i]);
            backtrack(nums, smallList, finalList);
            smallList.remove(smallList.size() - 1);
        }
    }
 }