package 思维题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 扩散法
public class Solution2808 {
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = nums.size();
        for (int i=0 ; i<len ; i++) {
            map.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        int ans = len;
        for (List<Integer> pos : map.values()) {
            int n = pos.size();
            int mx = len - pos.get(n-1) + pos.get(0);
            for (int i = 1 ; i < n ; i++) {
                mx = Math.max(mx, pos.get(i)-pos.get(i-1));
            }
            ans = Math.min(ans, mx);
        }
        return ans/2;
    }
}
