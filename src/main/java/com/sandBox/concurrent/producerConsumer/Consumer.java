package com.sandBox.concurrent.producerConsumer;



public class Consumer extends Thread{
    private Store store; //объект склада, с которого покупатель будет брать товар
    private int product=0; //текущее количество товаров со склада

    Consumer(Store store)
    {
        this.store=store;
    }

    public void run() {
        try
        {
            while(product<5){// пока количество товаров не будет равно 5

                product=product+store.get(); //берем по одному товару со склада
                System.out.println ("Потребитель купил " + product + " товар(ов)");
                sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println ("поток потребителя прерван");
        }
    }
}
