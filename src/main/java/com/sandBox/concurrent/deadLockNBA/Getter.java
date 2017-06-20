package com.sandBox.concurrent.deadLockNBA;

public class Getter implements Runnable {
    NBAPlayer player;

    public Getter(NBAPlayer player) {
        this.player = player;
    }

    @Override
    public void run() {
        try {
            player.getBall();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
