package 设计模式;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
    private static volatile Singleton instance;

    private void Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
