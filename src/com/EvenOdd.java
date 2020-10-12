package com.concurrency;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author - Mintu
 */
public class EvenOdd {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        LinkedList<Integer> numberList = IntStream.range(0, 10).boxed().collect(Collectors.toCollection(LinkedList::new));
        Runnable evenRunnable = new PrintEven(numberList, lock);
        Runnable oddRunnable = new PrintOdd(numberList, lock);
        Thread even = new Thread(evenRunnable, "even");
        Thread odd = new Thread(oddRunnable, "odd");
        odd.start();
        even.start();
        odd.join();
        even.join();
    }
}

class PrintEven implements Runnable {
    LinkedList<Integer> numberList;
    Object lock;

    PrintEven(LinkedList<Integer> numberList, Object lock) {
        this.numberList = numberList;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (!numberList.isEmpty()) {
            synchronized (lock) {
                if (numberList.peek() % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + numberList.poll());
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class PrintOdd implements Runnable {
    LinkedList<Integer> numberList;
    Object lock;

    PrintOdd(LinkedList<Integer> numberList, Object lock) {
        this.numberList = numberList;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (!numberList.isEmpty()) {
            synchronized (lock) {
                if (numberList.peek() % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + numberList.poll());
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}