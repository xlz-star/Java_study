package com.xlz.juc;

public class T2_HowToCreateThread {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread");
        }
    }

    public static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello New Runnable");
            }
        }).start();
        new Thread(()-> {
            System.out.println("Hello Lambda");
        }).start();
    }
}
