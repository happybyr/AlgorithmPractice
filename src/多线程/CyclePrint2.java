package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//3和线程循环打印，打印到300
public class CyclePrint2 {
    Lock lock = new ReentrantLock();
    int cur = 0;

    public void printNum(int tarNum) {
        int i = 0;
        while (i < 100) {
            lock.lock();
            try {
                if (cur % 3 == tarNum) {
                    System.out.println(cur);
                    cur++;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CyclePrint2 cp = new CyclePrint2();
        Thread threadA = new Thread(() -> cp.printNum(0));
        Thread threadB = new Thread(() -> cp.printNum(1));
        Thread threadC = new Thread(() -> cp.printNum(2));
        threadA.start();
        threadB.start();
        threadC.start();

//        threadA.join();
//        threadB.join();
//        threadC.join();
    }
}
