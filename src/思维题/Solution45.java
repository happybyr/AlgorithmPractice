package 思维题;

public class Solution45 {
    public int jump(int[] nums) {
        int start = 0, end = 0, ans = 0;
        while (end < nums.length-1) {
            int maxPos = end;
            for (int i=start ; i<=end ; i++) {
                maxPos = Math.max(maxPos, i+nums[i]);
            }
            start = end+1;
            end = maxPos;
            ans++;
        }
        return ans;
    }
}
