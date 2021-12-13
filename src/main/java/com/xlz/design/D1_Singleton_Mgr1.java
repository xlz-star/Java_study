package com.xlz.design;

/**
 * 单例模式：
 *  懒汉式
 *  类加载到内存后，就实例化一个单例，JVM保证线程安全
 *  简单实用，推荐使用，
 *  唯一缺点：无论使用与否，类装载是就完成实例化
 *  Class.forName()
 *
 */
public class D1_Singleton_Mgr1 {
    private static final D1_Singleton_Mgr1 INSTANCE = new D1_Singleton_Mgr1();

    private D1_Singleton_Mgr1() {};

    public static D1_Singleton_Mgr1 getInstance() { return INSTANCE; }

    public static void main(String[] args) {
        D1_Singleton_Mgr1 m1 = D1_Singleton_Mgr1.getInstance();
        D1_Singleton_Mgr1 m2 = D1_Singleton_Mgr1.getInstance();
        System.out.println(m1 == m2);

    }
}
