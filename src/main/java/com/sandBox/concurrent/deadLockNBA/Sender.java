package com.sandBox.concurrent.deadLockNBA;

public class Sender implements Runnable {
    private final NBAPlayer player;

    public Sender(NBAPlayer player) {
        this.player = player;
    }

    @Override
    public void run() {
        try {
            player.throwBall();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
