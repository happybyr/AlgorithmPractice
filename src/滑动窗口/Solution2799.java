package 滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2799 {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int m = set.size();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.size() == m) {
                int x = nums[left++];
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) {
                    map.remove(x);
                }
            }
            ans += left;
        }
        return ans;
    }
}
