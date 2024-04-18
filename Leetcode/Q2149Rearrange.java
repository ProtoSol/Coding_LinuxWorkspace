/**
2149. Rearrange Array Elements by Sign
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

 

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
 

Constraints:

2 <= nums.length <= 2 * 105
nums.length is even
1 <= |nums[i]| <= 105
nums consists of equal number of positive and negative integers.
 

It is not required to do the modifications in-place.
 */

import java.util.Arrays;
public class Q2149Rearrange {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        Solution obj = new Solution();
        nums = obj.rearrangeArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}

// class Solution {
//     public void rearrangeArray(int[] nums) {
//         int[] positive = new int[nums.length];
//         int[] negative = new int[nums.length];
//         int j = 0;
//         int k = 0;
//         for(int i = 0; i < nums.length; i++){
//             if(nums[i] > 0){
//                 positive[j++] = nums[i];
//             } else {
//                 negative[k++] = nums[i];
//             }
//         }
//         // Merge positive and negative arrays ensuring alternating signs
//         int index = 0;
//         for(int i = 0; i < j; i++){
//             nums[index++] = positive[i];
//             nums[index++] = negative[i];
//         }
//         System.out.println(Arrays.toString(nums));
//     }
// }

//  Better Approach By direct injection to new array

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int arr[]=new int[nums.length];
        int a=0;
        int b=1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<0) {
                arr[b]=nums[i];
                b+=2;
            } else {
                arr[a]=nums[i];
                a+=2;
            }
        }
        return arr;
    }
}