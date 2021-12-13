package com.xlz.juc;

/**
 * synchronized关键字
 * 对某个对象加锁
 */
public class T5_ThreadSynchronized {
    private int count = 10;
    private static int cnt = 10;
    private Object o = new Object();

    public void m1(){
        /*
        new 一个对象锁
         */
        synchronized (o) {
            count--;
            System.out.printf("%s count= %d", Thread.currentThread().getName(), count);
        }
    }

    public void m2() {
        /*
        使用当前对象作为锁
         */
        synchronized (this ) {
            count--;
            System.out.printf("%s count= %d", Thread.currentThread().getName(), count);
        }
    }

    public synchronized void m3() {
        /*
        synchronized方法，等同于m2()
         */
        count--;
        System.out.printf("%s count= %d", Thread.currentThread().getName(), count);
    }

    public synchronized static void m4() {
        /*
        静态方法没有this对象，这里相当于synchronized(T.class)
         */
        cnt--;
    }
}
