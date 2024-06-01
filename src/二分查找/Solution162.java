package 二分查找;

public class Solution162 {
//  最早在 33. 搜索旋转排序数组 中，我们强调，二分的本质是「二段性」而非「单调性」，
//  而经过本题，我们进一步发现「二段性」还能继续细分，不仅仅只有满足 010101 特性（满足/不满足）的「二段性」可以使用二分，
//  满足 1?1?1? 特性（一定满足/不一定满足）也可以二分。

//    https://leetcode.cn/problems/find-peak-element/description/?envType=daily-question&envId=2023-12-18

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = l + (r-l)/2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
