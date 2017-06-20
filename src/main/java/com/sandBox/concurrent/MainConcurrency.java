package com.sandBox.concurrent;

public class MainConcurrency {
    static int count = 0;
    static Object LOCK = new Object();
    public static void main(String[] args) throws InterruptedException {
    MainConcurrency mainConcurrency = new MainConcurrency();
        System.out.println(Thread.currentThread().getName());
        new Thread(){
            @Override
            public void run() {
                System.out.println(getName() + ", " + Thread.currentThread().getState());
            }
        }.start();
        new Thread(()-> {
            System.out.println("HElp me");
        }).start();
        for(int i=0; i<100; i++){
                new Thread(()->{
                    for (int j = 0; j < 10; j++) {
                        mainConcurrency.addCount();
                    }
                }).start();
             }
             Thread.sleep(500);
        System.out.println(count);
    }
    public  void addCount(){
       synchronized (this){
           count++;
       }

    }
}
