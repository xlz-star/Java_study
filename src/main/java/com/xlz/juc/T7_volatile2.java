package com.xlz.juc;

import java.util.ArrayList;
import java.util.List;

public class T7_volatile2 {
    /**
     * volatile 并不能保证多个线程共同修改running变量时所带来的的不一致问题，也就是说volatile不嫩替代synchronized
     *
     */
    volatile int count = 0;
    void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T7_volatile2 t = new T7_volatile2();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-"+i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
