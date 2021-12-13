package com.xlz.juc;

import java.util.concurrent.TimeUnit;

public class T9_LockObj {
    /**
     * 锁定某个对象o，如果o的属性发生改变，不影响锁的使用
     * 但是如果o变成一个对象，则锁定的对象发生改变
     * 应该避免将锁定对象的引用变成另外的对象
     */

    /* final */ Object o = new Object();

    void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        T9_LockObj t = new T9_LockObj();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.MICROSECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(t::m, "t2");
        t.o = new Object(); // 锁的对象发生改变，所以t2线程得以执行，如果注释这句话，那么线程2永远得不到执行的机会
        t2.start();
    }
}
