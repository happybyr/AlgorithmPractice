package 二分查找;

public class Solution154 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n-1;   // num[l-1] min左边  num[h] min及其右边
        while (l < h) {
            int mid = l + (h-l) / 2;
            if (nums[mid] < nums[h]) {
                h = mid;
            } else if (nums[mid] > nums[h]) {
                l = mid + 1;
            } else {
                h--;
            }
        }
        return nums[l];
    }

//    public int findMin2(int[] nums) {
//        int left = -1, right = nums.length - 1; // 开区间 (-1, n-1)
//        while (left + 1 < right) { // 开区间不为空
//            int mid = (left + right) >>> 1;
//            if (nums[mid] < nums[right]) right = mid; // 蓝色
//            else if (nums[mid] > nums[right]) left = mid; // 红色
//            else --right;
//        }
//        return nums[right];
//    }

    public static void main(String[] args) {
        System.out.println(new Solution154().findMin(new int[]{3,1,3}));
    }
}
