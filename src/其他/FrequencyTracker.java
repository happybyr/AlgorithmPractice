package 其他;

import java.util.HashMap;
import java.util.Map;

class FrequencyTracker {
    private Map<Integer, Integer> cnt;
    private Map<Integer, Integer> freq;
    public FrequencyTracker() {
        cnt = new HashMap<>();
        freq = new HashMap<>();
    }
    
    public void add(int number) {
        int originFreq = cnt.getOrDefault(number, 0);
        cnt.put(number, originFreq + 1);
        if (originFreq > 0) {
            freq.put(originFreq, freq.get(originFreq) - 1);
        }
        int newFreq = originFreq+1;
        freq.put(newFreq, freq.getOrDefault(newFreq, 0) + 1);
    }
    
    public void deleteOne(int number) {
        if (!cnt.containsKey(number) || cnt.get(number) <= 0) {
            return;
        }
        int originFreq = cnt.get(number);
        cnt.put(number, originFreq - 1);
        freq.put(originFreq, freq.getOrDefault(originFreq, 0) - 1);
        freq.put(originFreq-1, freq.getOrDefault(originFreq-1, 0) + 1);
    }
    
    public boolean hasFrequency(int frequency) {
        return freq.containsKey(frequency) && freq.get(frequency) > 0;
    }
}