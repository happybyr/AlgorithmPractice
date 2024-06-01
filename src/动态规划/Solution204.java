package 动态规划;

import java.util.Arrays;

public class Solution204 {
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        for(int i = 2 ; i*i < n ; i++){
            if(isPrimes[i]){
                for(int j = 2 ; i*j < n ; j++){
                    isPrimes[i*j] = false;
                }
            }
        }
        int count = 0;
        for(int i=2 ; i<isPrimes.length ; i++){
            if(isPrimes[i]){
                count++;
            }
        }
        return count;
    }
}
