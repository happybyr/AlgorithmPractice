package 基本算法;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    public class Node {
        int key;
        int val;
        int freq;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    public class DoubleList {
        Node head;
        Node tail;
        int size;
        public DoubleList() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public void addNode(Node node) {
            node.next = head.next;
            node.next.pre = node;
            node.pre = head;
            head.next = node;
            size++;
        }

        public Node removeTail() {
            Node node = tail.pre;
            removeNode(node);
            return node;
        }
    }

    int minFreq;
    int capacity;
    Map<Integer, Node> map;
    Map<Integer, DoubleList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int oldFreq = node.freq;
        freqMap.get(oldFreq).removeNode(node);
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DoubleList()).addNode(node);
        if (freqMap.get(oldFreq).size == 0) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) {
                minFreq = oldFreq+1;
            }
        }
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            freqMap.get(node.freq).removeNode(node);
            if (freqMap.get(node.freq).size == 0) {
                freqMap.remove(node.freq);
                if (minFreq == node.freq) {
                    minFreq++;
                }
            }
            node.freq++;
            freqMap.computeIfAbsent(node.freq, k -> new DoubleList()).addNode(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() < capacity) {
               map.put(key, node);
               freqMap.computeIfAbsent(1, k -> new DoubleList()).addNode(node);
               minFreq = 1;
            } else {
                Node removed = freqMap.get(minFreq).removeTail();
                map.remove(removed.key);
                if (freqMap.get(minFreq).size == 0) {
                    freqMap.remove(minFreq);
                }
                map.put(key, node);
                freqMap.computeIfAbsent(1, k -> new DoubleList()).addNode(node);
                minFreq = 1;
            }
        }
    }
}