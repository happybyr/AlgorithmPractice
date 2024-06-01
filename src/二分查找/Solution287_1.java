package 二分查找;

public class Solution287_1 {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1, right = len-1; // (..., left]重复数及其左边 [right, ...)重复数及其右边
        while (left < right) {
            int mid = left + (right-left)/2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    // 链表法
    public int findDuplicate_2(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
