package com.sandBox.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Mconcurrency {
    private static final int THREAD_NUMBER = 1000;
    private int counter;
    private static final AtomicInteger atomicCounter = new AtomicInteger();
    private static final ReentrantReadWriteLock rentrantReadWrite = new ReentrantReadWriteLock();
    private static final Lock WRITE_LOCK = rentrantReadWrite.writeLock();
    private static final Lock READ_LOCK = rentrantReadWrite.readLock();
    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat();
        }

    };

    public static void main(String[] args) throws InterruptedException {
        final Mconcurrency mainConcurrency = new Mconcurrency();
        CountDownLatch latch = new CountDownLatch(THREAD_NUMBER);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());

            }
            public  void addCount(){
                synchronized (this){
                  // atomicCounter++;
                }

            }
        }).start();
        for (int i = 0; i < THREAD_NUMBER ; i++) {
            Future<Integer> future = executorService.submit(()-> {
                for (int j = 0; j < 100; j++) {

                    mainConcurrency.addCount();
                    System.out.println(threadLocal.get().format(new Date()));
                }latch.countDown();
                return 5;
            });
        }
        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println(mainConcurrency.atomicCounter.get());
    }
    private static void deadLock(Object lock1, Object lock2){
        new Thread(()->{
            System.out.println("waiting" + lock1);
            synchronized (lock1){
                System.out.println("holding" + lock1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("waiting" + lock2);
                synchronized (lock2){
                    System.out.println("holding" + lock2);
                }
            }
        }).start();
    }
    private void addCount(){
        atomicCounter.incrementAndGet();
        }

}
