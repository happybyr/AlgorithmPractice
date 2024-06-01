package 二分查找;

public class Solution153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = -1, h = n-1;    // 开区间  nums[l] min左边   num[h] min及其右边
        while (l + 1 < h) {
            int mid = l + (h-l)/2;
            if (nums[mid] >= nums[n-1]) {
                l = mid;
            } else {
                h = mid;
            }
        }
        return nums[h];
    }

    public int findMin2(int[] nums) {
        int n = nums.length;
        int l = 0, h = n-1;   // 左闭右开  nums[l-1] min左边   num[h] min及其右边
        while (l < h) {
            int mid = l + (h-l)/2;
            if (nums[mid] >= nums[n-1]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return nums[h];
    }
}
