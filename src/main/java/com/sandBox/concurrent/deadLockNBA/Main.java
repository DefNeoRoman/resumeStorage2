package com.sandBox.concurrent.deadLockNBA;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NBAPlayer player = new NBAPlayer();
        Sender sender = new Sender(player);
        Getter getter = new Getter(player);

        for (int i = 0; i <6 ; i++) {
            Thread t = new Thread(sender,"sender");
            Thread th = new Thread(getter,"getter");
            t.start();
            Random random = new Random();
            Thread.sleep(random.nextInt(500)+500);
            th.start();

        }
    }

}
