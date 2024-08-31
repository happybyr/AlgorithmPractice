package 二分查找;

import java.util.Random;

public class Solution528 {
    int[] sum;
    int total;
    public Solution528(int[] w) {
        sum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sum[i] = total;
        }
    }

    public int pickIndex() {
        Random r = new Random();
        int i = r.nextInt(total);
        int l = -1, h = sum.length-1;
        while (l + 1 < h) {
            int mid = l + (h-l)/2;
            if (sum[mid] > i) {
                h = mid;
            } else {
                l = mid;
            }
        }
        return h;
    }
}
