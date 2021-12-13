package com.xlz.juc;

import java.util.concurrent.TimeUnit;

public class T7_volatile {
    /**
     * volatile
     *  作用：
     *      · 保证线程可见性
     *      · 禁止指令重排序
     *          - DCL单例
     *          - Double Check Lock
     *          - Mgr06.java
     */
    volatile  boolean running = true;
    void m() {
        System.out.println("m start");
        while (running) {
            /*
            try {
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T7_volatile t = new T7_volatile();

        new Thread(t::m, "t1").start();
        try {
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
