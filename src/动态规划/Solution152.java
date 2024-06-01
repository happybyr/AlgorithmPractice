package 动态规划;

import java.util.TreeMap;

public class Solution152 {
    public int maxProduct(int[] nums) {
        int iMax = 1;
        int iMin = 1;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }
            iMax = Math.max(num, iMax * num);
            iMin = Math.min(num, iMin * num);
            max = Math.max(max, iMax);
        }
        return max;
    }
}
