package com.xlz.juc;

public class T6_TestSynchronized implements Runnable {

    private /* volatile */ int count = 100;

    @Override
    public synchronized void run() {
        count--;
        System.out.printf("%s count = %d\n", Thread.currentThread().getName(), count);
    }

    public static void main(String[] args) {
        T6_TestSynchronized t = new T6_TestSynchronized();
        for (int i = 0; i < 100; i++) {
            new Thread(t, "THREAD"+i).start();
        }
    }

}
