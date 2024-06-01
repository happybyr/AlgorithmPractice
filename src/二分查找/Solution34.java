package 二分查找;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound1(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        int end = lowerBound1(nums, target+1) - 1;
        return new int[]{start, end};
    }

    private int lowerBound1(int[] nums, int target) {
        // 左闭右闭
        int l = 0, h = nums.length-1;
        // 循环不变量：nums[l-1] < target, nums[h+1] >= target
        while (l <= h) {
            int mid = l + (h-l)/2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    private int lowerBound2(int[] nums, int target) {
        // 左闭右开
        int l = 0, h = nums.length;
        // 循环不变量：nums[l-1] < target, nums[h] >= target
        while (l < h) {
            int mid = l + (h-l)/2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    private int lowerBound3(int[] nums, int target) {
        // 左开右开
        int l = -1, h = nums.length;
        // 循环不变量：nums[l] < target, nums[h] >= target
        while (l + 1 < h) {
            int mid = l + (h-l)/2;
            if (nums[mid] < target) {
                l = mid;
            } else {
                h = mid;
            }
        }
        return h;
    }
}
