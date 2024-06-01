package 二分查找;

public class Solution275 {
//    public int hIndex(int[] citations) {
//        int n = citations.length;
//
//        int l = 1 , h = n;
//        while (l <= h) {
//            int mid = l + (h - l) / 2;
//            if (citations[n-mid] >= mid) {
//                l = mid + 1;
//            } else {
//                h = mid - 1;
//            }
//        }
//        return h;
//    }

//    public int hIndex(int[] citations) {
//        int n = citations.length;
//
//        int l = 1 , h = n+1;
//        while (l < h) {
//            int mid = l + (h - l) / 2;
//            if (citations[n-mid] >= mid) {
//                l = mid + 1;
//            } else {
//                h = mid;
//            }
//        }
//        return h-1;
//    }

    public int hIndex(int[] citations) {
        int n = citations.length;

        int l = 0 , h = n+1;
        while (l+1 < h) {
            int mid = l + (h - l) / 2;
            if (citations[n-mid] >= mid) {
                l = mid;
            } else {
                h = mid;
            }
        }
        return l;
    }
}
