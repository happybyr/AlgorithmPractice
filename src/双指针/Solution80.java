package 双指针;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int num : nums) {
            if (slow < 2 || nums[slow-2] != num) {
                nums[slow++] = num;
            }
        }
        return slow;
    }
}
