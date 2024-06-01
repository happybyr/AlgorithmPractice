package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//3和线程循环打印，打印到300
public class CyclePrint3 {
    Lock lock = new ReentrantLock();
    int cur = 0;
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition C3 = lock.newCondition();

    public void printNum(int tarNum, Condition currentThread, Condition nextThread) {
        for (int i=0 ; i<100 ; i++) {
            lock.lock();
            try {
                while (cur % 3 != tarNum) {
                    currentThread.await();
                }
                System.out.println(cur);
                cur++;
                nextThread.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CyclePrint3 cp = new CyclePrint3();
        Thread threadA = new Thread(() -> cp.printNum(0, cp.c1, cp.c2));
        Thread threadB = new Thread(() -> cp.printNum(1, cp.c2, cp.C3));
        Thread threadC = new Thread(() -> cp.printNum(2, cp.C3, cp.c1));
        threadA.start();
        threadB.start();
        threadC.start();

//        threadA.join();
//        threadB.join();
//        threadC.join();
    }
}
