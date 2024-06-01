package 排序;

import java.util.Arrays;

public class BubbleSort {
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i=0 ; i<n-1 ; i++) {
            for (int j=0 ; j<n-i-1 ; j++) {
                if (nums[j+1] < nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public void bubbleSort2(int[] nums) {
        int n = nums.length;
        boolean flag = true;
        for (int i=0 ; i<n-1 ; i++) {
            if (flag) {
                flag = false;
                for (int j=0 ; j<n-i-1 ; j++) {
                    if (nums[j+1] < nums[j]) {
                        int tmp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = tmp;
                        flag = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,1,3,5,0,2,1,10,7};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {2,1,3,5,0,2,1,10,7};
        bs.bubbleSort2(b);
        System.out.println(Arrays.toString(b));
    }
}
