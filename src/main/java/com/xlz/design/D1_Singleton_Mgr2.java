package com.xlz.design;

/**
 * lazy loading
 * 也称为懒汉式
 * 虽然达到了按需初始化的目的，但也带来了线程不安全的风险
 */
public class D1_Singleton_Mgr2 {
    private static D1_Singleton_Mgr2 INSTANCE;

    private D1_Singleton_Mgr2() {};

    public static D1_Singleton_Mgr2 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new D1_Singleton_Mgr2();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(D1_Singleton_Mgr2.getInstance().hashCode());
            }).start();
        }

    }
}
