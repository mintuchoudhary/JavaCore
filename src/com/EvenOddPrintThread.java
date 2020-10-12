package com.concurrency;
//@author - Mintu
public class EvenOddPrintThread {

    public static void main(String[] args) throws Exception{
          int counter = 0;
        EvenThread evenThread = new EvenThread(counter);
        OddThread oddThread = new OddThread(counter);

        Thread t1 = new Thread(evenThread);
        Thread t2 = new Thread(oddThread);
        t1.start();
        t2.start();

    }
}

class EvenThread implements Runnable {
    int counter;

    EvenThread(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter < 50) {
            counter = counter + 1;
            if (counter % 2 == 0) {
                System.out.println("even thread:" + counter);
                try {
                    //Thread.sleep(1000);
                } catch (Exception ex) {
                }
            }
        }
    }
}

class OddThread implements Runnable {
    int counter;

    OddThread(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter < 50) {
            counter = counter + 1;

            if (counter % 2 != 0) {
                System.out.println("odd thread:" + counter);
                try {
                    //     Thread.sleep(1000);
                } catch (Exception ex) {
                }
            }
        }
    }
}

/**
 even thread:2
 odd thread:1
 odd thread:3
 odd thread:5
 even thread:4
 odd thread:7
 odd thread:9
 odd thread:11
 odd thread:13
 odd thread:15
 even thread:6
 odd thread:17
 even thread:8
 odd thread:19
 even thread:10
 odd thread:21
 odd thread:23
 odd thread:25
 even thread:12
 odd thread:27
 odd thread:29
 odd thread:31
 even thread:14
 odd thread:33
 odd thread:35
 odd thread:37
 odd thread:39
 even thread:16
 odd thread:41
 odd thread:43
 odd thread:45
 odd thread:47
 odd thread:49
 even thread:18
 even thread:20
 even thread:22
 even thread:24
 even thread:26
 even thread:28
 even thread:30
 even thread:32
 even thread:34
 even thread:36
 even thread:38
 even thread:40
 even thread:42
 even thread:44
 even thread:46
 even thread:48
 even thread:50
*/