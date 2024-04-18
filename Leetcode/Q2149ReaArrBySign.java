// package codingQues;

/**
 * Q2149RearrangeArrayElementsBySign
 */
public class Q2149ReaArrBySign {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        Solution sol = new Solution();
        sol.rearrangeArray(nums);
    }
}
class Solution {
    public void rearrangeArray(int[] nums) {
        Integer[] positive = new Integer[nums.length/2];
        Integer[] negative = new Integer[nums.length/2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums.length){
            if(nums[i] < 0){
                negative[j] = nums[i];
                j++;
            } else {
                positive[k] = nums[i];
                k++;
            }
            i++;
        }
        System.out.println(negative.toString());
        System.out.println(positive.toString());
    }
}