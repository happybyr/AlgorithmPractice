package 排序;

import java.util.Arrays;

public class HeapSort {
    public void heapSort(int[] nums) {
        int n = nums.length;
        for (int i=n/2-1 ; i>=0 ; i--) {
            heapify(nums, i, n);
        }

        for (int i=n-1 ; i > 0 ; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            heapify(nums, 0, i);
        }
    }

    private void heapify(int[] nums, int i, int maxLen) {
        int maxIdx = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left < maxLen && nums[left] > nums[maxIdx]) {
            maxIdx = left;
        }
        if (right < maxLen && nums[right] > nums[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            int tmp = nums[i];
            nums[i] = nums[maxIdx];
            nums[maxIdx] = tmp;
            heapify(nums, maxIdx, maxLen);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
