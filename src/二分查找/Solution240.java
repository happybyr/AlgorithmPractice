package 二分查找;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0 ; i<m ; i++) {
            int l = 0, h = n-1;
            boolean found = false;
            while (l <= h) {
                int mid = l + (h-l)/2;
                if (matrix[i][mid] > target) {
                    h = mid-1;
                } else if (matrix[i][mid] < target) {
                    l = mid+1;
                } else {
                    found = true;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution240().searchMatrix(new int[][]{{1,3,5,7,9},{10,11,16,20,25},{25,26,30,35,40},{45,50,55,60,61}}, 3);
    }
}
