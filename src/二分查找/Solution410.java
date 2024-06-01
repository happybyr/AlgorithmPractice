package 二分查找;

public class Solution410 {
//    public int splitArray(int[] nums, int k) {
//        int max = 0, sum = 0;
//        for (int num : nums) {
//            max = Math.max(max, num);
//            sum += num;
//        }
//        int l = max, h = sum;
//        // l-1 分出来大于k
//        // h+1 分出来小于等于k
//        while (l <= h) {
//            int mid = l + (h-l)/2;
//            if (split(nums, mid) <= k) {
//                h = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return l;
//    }

//    public int splitArray(int[] nums, int k) {
//        int max = 0, sum = 0;
//        for (int num : nums) {
//            max = Math.max(max, num);
//            sum += num;
//        }
//        int l = max, h = sum+1;
//        // l-1 分出来大于k
//        // h 分出来小于等于k
//        while (l < h) {
//            int mid = l + (h-l)/2;
//            if (split(nums, mid) <= k) {
//                h = mid;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return l;
//    }

    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int l = max-1, h = sum+1;
        // l 分出来大于k
        // h 分出来小于等于k
        while (l+1 < h) {
            int mid = l + (h-l)/2;
            if (split(nums, mid) <= k) {
                h = mid;
            } else {
                l = mid;
            }
        }
        return h;
    }

    private int split(int[] nums, int mid) {
        int ans = 0;
        int curSum = 0;
        for (int num : nums) {
            if (curSum + num > mid) {
                ans++;
                curSum = num;
            } else {
                curSum += num;
            }
        }
        return ans+1;
    }
}
