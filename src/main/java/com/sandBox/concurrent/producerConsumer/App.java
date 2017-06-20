package com.sandBox.concurrent.producerConsumer;

public class App {
    public static void main(String[] args) {

        Store store = new Store();
        new Producer(store).start();
        new Consumer(store).start();
    }
}
