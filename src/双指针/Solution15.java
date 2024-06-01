package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int i=0 ; i<n-2 ; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                if (nums[i] > 0) {
                    break;
                }
                int target = -nums[i];
                int l = i+1, h = n-1;
                while (l < h) {
                    if (nums[l] + nums[h] < target) {
                        l++;
                    } else if (nums[l] + nums[h] > target) {
                        h--;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[h])));
                        int low = nums[l];
                        while (l < h && nums[l] == low) {
                            l++;
                        }
                        int high = nums[h];
                        while (l < h && nums[h] == high) {
                            h--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
