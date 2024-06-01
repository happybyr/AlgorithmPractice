package 多线程;

//3和线程循环打印，打印到300
public class CyclePrint {
    Object obj = new Object();
    int cur = 0;

    public void printNum(int tarNum) {
        for (int i=0 ; i<100 ; i++) {
            synchronized (obj) {
                while (cur % 3 != tarNum) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(cur);
                cur++;
                obj.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CyclePrint cp = new CyclePrint();
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
