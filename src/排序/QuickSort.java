package 排序;

import java.util.Arrays;

public class QuickSort {
    public void sortArr(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int l = start, h = end;
        while (l < h) {
            while (l < h && nums[h] >= pivot) {
                h--;
            }
            if (l < h) {
                swap(nums, l++, h);
            }
            while (l < h && nums[l] <= pivot) {
                l++;
            }
            if (l < h) {
                swap(nums, l, h--);
            }
        }
        nums[l] = pivot;
        quickSort(nums, start, l - 1);
        quickSort(nums, l + 1, end);
    }

    private void swap (int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 6, 5, 3, 4};
        new QuickSort().sortArr(nums);
        System.out.println(Arrays.toString(nums));
    }
}
