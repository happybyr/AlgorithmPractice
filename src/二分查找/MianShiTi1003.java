package 二分查找;
//https://leetcode.cn/problems/search-rotate-array-lcci/
public class MianShiTi1003 {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int l = 0, h = n-1;
        while (l <= n-1 && arr[l] == arr[h]) {
            l++;
        }
        if (l == n) {
            return arr[h] == target ? 0 : -1;
        }
        while(l < h) {
            int mid = l + (h-l)/2;
            if (arr[mid] <= arr[n-1]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        int idx = l;
        if (target >= arr[0]) {
            l = 0;
            h = idx-1;
        } else {
            l = idx;
            h = n-1;
        }
        h++;
        while (l < h) {
            int mid = l + (h-l)/2;
            if (arr[mid] >= target) {
                h = mid;
            } else {
                l = mid+1;
            }
        }

        if (l > n-1) {
            return -1;
        } else {
            return arr[l] == target ? l : -1;
        }
    }
}
