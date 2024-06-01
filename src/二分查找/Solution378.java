package 二分查找;

public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int  m = matrix.length;
        int n = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[m-1][n-1];
        while (left < right) {
            int mid = left + (right-left)/2;
            if (countNoBiggerThan(matrix, mid) < k) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countNoBiggerThan(int[][] matrix, int target) {
        int i=matrix.length-1;
        int j = 0;
        int ans = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] <= target) {
                ans += i+1;
                j++;
            } else {
                i--;
            }
        }
        return ans;
    }
}
