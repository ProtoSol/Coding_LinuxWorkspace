// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDupSorted {

    public int removeDuplicates(int[] nums) {
        int index = 1;
        int occurance = 1;

        for(int i=1; i < nums.length; i++){
            if (nums[i] == nums[i-1]){
                occurance++;
            }else{
                occurance = 1;
            }

            if (occurance <= 2){
                nums[index] = nums[i];
                index++;
            }
        }  

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        RemoveDupSorted obj = new RemoveDupSorted();
        int length = obj.removeDuplicates(nums);
        for(int i=0; i < length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}