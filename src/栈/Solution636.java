package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int curTime = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : logs) {
            String[] record = str.split(":");
            int func = Integer.valueOf(record[0]);
            String type = record[1];
            int time = Integer.valueOf(record[2]);
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    res[stack.peekLast()] += (time - curTime);
                }
                stack.addLast(func);
                curTime = time;
            } else {
                res[stack.pollLast()] += (time - curTime + 1);
                curTime = time + 1;
            }
        }
        return res;
    }
}
