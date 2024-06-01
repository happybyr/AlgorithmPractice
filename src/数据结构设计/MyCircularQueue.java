package 数据结构设计;

class MyCircularQueue {
    int capacity;
    int[] arr;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear + capacity -1) % capacity];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}