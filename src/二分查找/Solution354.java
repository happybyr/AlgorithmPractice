package 二分查找;

import java.util.Arrays;

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] list = new int[envelopes.length];
        for(int i=0 ; i<envelopes.length ; i++){
            list[i] = envelopes[i][1];
        }

        return lengthOfLIS(list);
    }

    private int lengthOfLIS(int[] list){
        int n = list.length;
        int[] tail = new int[n];
        int size = 0;
        for(int num : list){
            int l = 0 , h = size;
            while(l < h){
                int mid = l + (h-l)/2;
                if(tail[mid] < num){
                    l = mid+1;
                }else{
                    h = mid;
                }
            }
            tail[l] = num;
            if(l == size) size++;
        }
        return size;
    }
}
