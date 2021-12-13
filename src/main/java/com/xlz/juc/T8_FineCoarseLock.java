package com.xlz.juc;

import java.util.concurrent.TimeUnit;

public class T8_FineCoarseLock {
    /**
     * synchronized优化
     * 同步代码块中的语句越少越好
     */

    int count = 0;

    synchronized void m1() {
        // 一些不需要上锁的逻辑
        try {
            TimeUnit.MICROSECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TODO 业务逻辑中只有下面这句需要sync， 这时不应该给整个方法上锁
        count++;
        // 一些需要上锁的逻辑
        try {
            TimeUnit.MICROSECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        // 一些不需要上锁的逻辑
        try {
            TimeUnit.MICROSECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TODO 业务逻辑中只有下面这句需要sync， 这时不应该给整个方法上锁
        synchronized (this) {
            count++;
        }
        // 一些需要上锁的逻辑
        try {
            TimeUnit.MICROSECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

    }
}
