package 贪心;

import java.util.Arrays;

public class Solution1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] arr = new int[n][2];
        for (int i=0 ; i<n ; i++) {
            arr[i][0] = aliceValues[i] + bobValues[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        int aliceSum = 0, bobSum = 0;
        for (int i=0 ; i<n ; i++) {
            if (i % 2 == 0) {
                aliceSum += aliceValues[arr[i][1]];
            } else {
                bobSum += bobValues[arr[i][1]];
            }
        }
        if (aliceSum > bobSum) {
            return 1;
        } else if (bobSum > aliceSum) {
            return -1;
        } else {
            return 0;
        }
    }
}
