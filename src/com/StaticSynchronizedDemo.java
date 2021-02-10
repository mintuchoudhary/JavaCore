package com;

/*
If you make any static method as synchronized, the lock will be on the class not on object.
 */
public class StaticSynchronizedDemo {
    synchronized static  void printTable(int n){
        for(int i=1;i<=10;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){}
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                printTable(2);
            }
        };
        t1.start();
    }
}
