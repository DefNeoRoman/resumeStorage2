package com.sandBox.concurrent.producerConsumer;

public class Producer extends Thread {
    Store store;
    int product = 5;

    Producer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        try
        {
            while(product>0){ //пока у производителя имеются товары
                product=product-store.put(); //кладем один товар на склад
                System.out.println ("производителю осталось произвести " + product + " товар(ов)");
                sleep(1000); // время простоя
            }
        }
        catch(InterruptedException e)
        {
            System.out.println ("поток производителя прерван");
        }
    }
    }

