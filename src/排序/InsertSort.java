package 排序;

import java.util.Arrays;

public class InsertSort {
    public void insertSort(int[] nums) {
        int n = nums.length;
        for (int i=1 ; i<n ; i++) {
            int insert = nums[i];
            int j = i-1;
            while (j >=0 && nums[j] > insert) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = insert;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,1,3,5,0,2,1,10,7};
        InsertSort bs = new InsertSort();
        bs.insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
