package com.sandBox.concurrent.deadlockExample;

/**
 * Created by Пользователь on 14.06.2017.
 */
public class Friend {
    private String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void bow(Friend bower){

        System.out.println(this.getName()+" кланяется " + bower.getName()+"\n");
        bower.bowBack(this);
    }
    public synchronized void bowBack(Friend bower){

        System.out.format(bower.getName() + "откланивается назад от " + this.getName()+"\n" );
    }
}
