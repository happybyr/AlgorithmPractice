package 排序;

import java.util.Arrays;

public class ShellSort {
    public void shellSort(int[] nums) {
        int n = nums.length;
        for (int gap = n/2 ; gap > 0 ; gap /= 2) {
            for (int i=gap ; i<n ; i++) {
                int insert = nums[i];
                int j = i-gap;
                while (j >= 0 && nums[j] > insert) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = insert;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
