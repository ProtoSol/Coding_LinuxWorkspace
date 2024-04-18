import java.util.Arrays;

public class Q2149Array {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        Solution sol = new Solution();
        sol.buildArray(nums);
    }
}
class Solution {
    public void buildArray(int[] nums) {
        int[] list = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            list[i] = nums[nums[i]];
        }
        System.out.println(Arrays.toString(list));
        // return list;    
    }
}
// Works less go
