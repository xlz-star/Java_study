package com.xlz.design;

/**
 * lazy loading
 * 也称为懒汉式
 * 虽然达到了按需初始化的目的，但也带来了线程不安全的风险
 * 通过synchronized解决，但也带来了效率的下降
 * 试图采用减小同步代码的方式提高效率，然后不可行
 */
public class D1_Singleton_Mgr4 {
    private static D1_Singleton_Mgr4 INSTANCE;

    private D1_Singleton_Mgr4() {};

    public static D1_Singleton_Mgr4 getInstance() {
        if (INSTANCE == null) {
            synchronized (D1_Singleton_Mgr4.class) { // TODO 试图采用减小同步代码的方式提高效率，然后不可行
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new D1_Singleton_Mgr4();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(D1_Singleton_Mgr4.getInstance().hashCode());
            }).start();
        }

    }
}
