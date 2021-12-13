package com.xlz.design;

/**
 * lazy loading
 * 也称为懒汉式
 * 虽然达到了按需初始化的目的，但也带来了线程不安全的风险
 * 通过synchronized解决，但也带来了效率的下降
 * 试图采用减小同步代码的方式提高效率，然后不可行
 * 双重检查 | volatile
 */
public class D1_Singleton_Mgr5 {
    private static volatile D1_Singleton_Mgr5 INSTANCE; // TODO 不用volatile，可能会因为 指令重排序 造成逻辑错误

    private D1_Singleton_Mgr5() {}

    public static D1_Singleton_Mgr5 getInstance() {
        if (INSTANCE == null) {
            synchronized (D1_Singleton_Mgr5.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new D1_Singleton_Mgr5();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(D1_Singleton_Mgr5.getInstance().hashCode());
            }).start();
        }

    }
}
