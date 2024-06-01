package 双指针;

import java.util.Arrays;

public class Solution611 {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=2 ; i<n ; i++) {
            int left = 0, right = i-1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ans += (right-left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
