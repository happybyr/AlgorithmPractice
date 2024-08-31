package 其他;

public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int index = 0;
        int x1 = 0, y1 = 0, sum = 0;
        while (sum < m + n -1) {
            x1 = sum > m-1 ? m-1 : sum;
            y1 = sum-x1;
            while (x1 >= 0 && y1 <= n-1) {
                res[index++] = mat[x1][y1];
                x1--;
                y1++;
            }
            sum++;

            y1 = sum > n-1 ? n-1 : sum;
            x1 = sum-y1;
            while (x1 <= m-1 && y1 >= 0) {
                res[index++] = mat[x1][y1];
                x1++;
                y1--;
            }
            sum++;
        }
        return res;
    }
}
