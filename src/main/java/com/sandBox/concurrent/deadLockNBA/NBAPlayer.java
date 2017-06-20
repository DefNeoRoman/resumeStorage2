package com.sandBox.concurrent.deadLockNBA;

public class NBAPlayer {
    private volatile boolean ready = false;
    public synchronized void throwBall() throws InterruptedException {
        while(ready){
            wait();
        }
        System.out.println("I throw a ball");
        ready = true;
        notify();
    }
    public synchronized void getBall() throws InterruptedException {
        while(!ready){
            wait();
        }
        System.out.println("I got a ball!");
        ready = false;
        notify();
    }
}
