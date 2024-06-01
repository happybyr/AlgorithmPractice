package 双指针;

public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int start = 0 , end = -1;
        int max = nums[0], min = nums[n-1];
        for (int i=0 ; i<n ; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                end = i;
            }

            if (nums[n-1-i] <= min) {
                min = nums[n-1-i];
            } else {
                start = n-1-i;
            }
        }
        return end-start+1;
    }
}
