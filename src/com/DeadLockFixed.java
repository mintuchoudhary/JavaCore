package com.java8;

public class DeadLockFixed {
    /**
     * NO DEADLOCK = Both THREAD are when requesting lock in same order, * first Integer and then String. * THEN either thread1 will get complete first and then thread2 or vice versa
     * DEADLOCK = when both thread are acquiring lock in different order i.e t1= first String and then Integer and t2=Integer,String
     * then either thread will acquire lock on object needed by other thread resulting in deadlock
     */

    public static void main(String[] args)  {

        DeadLockMethod deadlock = new DeadLockMethod();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadlock.method1();
                }catch(Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadlock.method2();
                }catch(Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        t1.start();
        t2.start();
    }

    static class DeadLockMethod {
        public void method1() throws Exception {
            synchronized (Integer.class) {
                System.out.println("Aquired lock on Integer.class object:"+Thread.currentThread().getName());
                Thread.sleep(1000);
                synchronized (String.class) {
                    System.out.println("Aquired lock on String.class object:"+Thread.currentThread().getName());
                }
            }
        }

        public void method2() throws Exception {
            synchronized (String.class) {
                 Thread.sleep(1000);
                System.out.println("Aquired lock on Integer.class object"+Thread.currentThread().getName());
                synchronized (Integer.class) {
                    System.out.println("Aquired lock on String.class object"+Thread.currentThread().getName());
                }
            }
        }
    }
}
