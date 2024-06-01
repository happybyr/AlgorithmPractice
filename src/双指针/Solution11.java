package 双指针;

public class Solution11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
