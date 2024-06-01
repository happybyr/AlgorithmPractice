package 数据结构设计;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// 380. O(1) 时间插入、删除和获取随机元素
class RandomizedSet {

    int[] nums;
    int idx;
    Map<Integer, Integer> map;
    Random random;
    public RandomizedSet() {
        nums = new int[200001];
        idx = -1;
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        idx++;
        map.put(val, idx);
        nums[idx] = val;
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int oldIdx = map.remove(val);
        if (oldIdx != idx) {
            map.put(nums[idx], oldIdx);
        }
        nums[oldIdx] = nums[idx--];
        return true;
    }
    
    public int getRandom() {
        return nums[random.nextInt(idx+1)];
    }
}