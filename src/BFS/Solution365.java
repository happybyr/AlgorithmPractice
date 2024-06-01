package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution365 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Long> seen = new HashSet<>();
        queue.add(new int[]{0, 0});
        seen.add(hash(new int[]{0, 0}));
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int remainX = cur[0];
            int remainY = cur[1];
            if (remainX == targetCapacity || remainY == targetCapacity || remainX + remainY == targetCapacity) {
                return true;
            }

            addIfAbsent(seen, queue, new int[]{jug1Capacity, remainY});
            addIfAbsent(seen, queue, new int[]{remainX, jug2Capacity});
            addIfAbsent(seen, queue, new int[]{0, remainY});
            addIfAbsent(seen, queue, new int[]{remainX, 0});
            addIfAbsent(seen, queue, new int[]{remainX + Math.min(remainY, jug1Capacity-remainX), remainY-Math.min(remainY, jug1Capacity-remainX)});
            addIfAbsent(seen, queue, new int[]{remainX-Math.min(remainX, jug2Capacity-remainY), remainY + Math.min(remainX, jug2Capacity-remainY)});
        }
        return false;
    }

    private void addIfAbsent(Set<Long> seen, Queue<int[]> queue, int[] arr) {
        if (!seen.contains(hash(arr))) {
            queue.add(arr);
            seen.add(hash(arr));
        }
    }

    private long hash(int[] arr) {
        return arr[0] * 1000001L + arr[1];
    }
}
