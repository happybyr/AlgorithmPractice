package 思维题;

public class Solution649 {
    public String predictPartyVictory(String senate) {
        char[] arr = senate.toCharArray();
        int n = arr.length;
        boolean hasR = true, hasD = true;
        int stopD = 0, stopR = 0;
        while (hasD && hasR) {
            hasD = false;
            hasR = false;
            for (int i=0 ; i<n ; i++) {
                if (arr[i] == 'R') {
                    if (stopR > 0) {
                        stopR--;
                        arr[i] = '0';
                    } else {
                        hasR = true;
                        stopD++;
                    }
                } else if (arr[i] == 'D') {
                    if (stopD > 0) {
                        stopD--;
                        arr[i] = '0';
                    } else {
                        hasD = true;
                        stopR++;
                    }
                }
            }
        }
        return hasR ? "Radiant" : "Dire";
    }
}
