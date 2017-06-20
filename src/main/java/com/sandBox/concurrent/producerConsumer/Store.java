package com.sandBox.concurrent.producerConsumer;

public class Store {
    int counter = 0;
    final int maxN = 5;

    synchronized int put(){
        if(counter <= maxN){
            counter++;
            System.out.println("склад имеет " + counter + " товаров");
            return 1;
        }
        return 0;

    }
    synchronized int get(){
        if(counter > 0){
            counter--;
            System.out.println("склад имеет " + counter + " товаров");
            return 1;
        }
        return 0;
    }
}
