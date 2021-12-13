package com.xlz.design;

/**
 * lazy loading
 * 也称为懒汉式
 * 虽然达到了按需初始化的目的，但也带来了线程不安全的风险
 * 通过synchronized解决，但也带来了效率的下降
 */
public class D1_Singleton_Mgr3 {
    private static D1_Singleton_Mgr3 INSTANCE;

    private D1_Singleton_Mgr3() {};

    public static synchronized D1_Singleton_Mgr3 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new D1_Singleton_Mgr3();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(D1_Singleton_Mgr3.getInstance().hashCode());
            }).start();
        }

    }
}
