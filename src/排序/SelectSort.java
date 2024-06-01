package 排序;

import java.util.Arrays;

public class SelectSort {
    public void selectSort(int[] nums) {
        int n = nums.length;
        for (int i=0 ; i<n ; i++) {
            int minIdx = i;
            for (int j=i ; j<n ; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = nums[minIdx];
            nums[minIdx] = nums[i];
            nums[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,1,3,5,0,2,1,10,7};
        SelectSort bs = new SelectSort();
        bs.selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
