package 二分查找;

public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0 , h = nums.length - 1;
        while(l < h){
            int mid = l + (h-l)/2;
            if(mid % 2 == 1){
                mid--;
            }
            if(nums[mid] !=nums[mid+1]){
                h = mid;
            }else{
                l = mid + 2;
            }
        }
        return nums[l];
    }
}
