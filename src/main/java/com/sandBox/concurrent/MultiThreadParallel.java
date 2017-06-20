package com.sandBox.concurrent;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadParallel {
    public static final int  THREADS_NUMBER = 10000;
    private static int counter;
    private static final Object LOCK = new Object();
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread0 = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        thread0.start();
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
        }).start();

        System.out.println(thread0.getState());
       final MultiThreadParallel mtp = new MultiThreadParallel();
        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);
        for (int i = 0; i < THREADS_NUMBER ; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                   mtp.inc();
                }
            });
            thread.start();
            threads.add(thread);


        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {// выброшенное и необработанное исключение приводит к завершению потоков
                e.printStackTrace();
            }
        });
        System.out.println(counter);


    }

    private  synchronized void inc() { // при слове synchronized в метод имеет право заходит только один поток


        counter++;


    }
}
