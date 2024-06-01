package 排序;

import java.util.Arrays;

public class MergeSort {
    public void sortArr(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int l = start, h = mid + 1;
        int index = 0;
        while (l <= mid || h <= end) {
            if (l > mid) {
                temp[index++] = nums[h++];
            } else if (h > end) {
                temp[index++] = nums[l++];
            } else if (nums[l] <= nums[h]) {
                temp[index++] = nums[l++];
            } else {
                temp[index++] = nums[h++];
            }
        }
        for (int i = 0 ; i < temp.length ; i++) {
            nums[start + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 4, 6, 7, 8, 9, 0};
        new MergeSort().sortArr(nums);
        System.out.println(Arrays.toString(nums));
    }
}
