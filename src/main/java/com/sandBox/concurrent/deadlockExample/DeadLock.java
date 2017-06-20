package com.sandBox.concurrent.deadlockExample;

//Алиса и Боб — друзья и большие приверженцы вежливости.
//        Строгое правило вежливости: когда вы кланяетесь другу
//        вы должны оставаться в поклоне до тех пор,
//        пока ваш друг тоже не поклонится вам.
//        Однако это правило не учитывает возможность,
//        когда оба друга кланяются одновременно:
//System.out.println() -> он потокобезопасный чтоле?
public class DeadLock {

    public static void main(String[] args) {
        final Friend alice = new Friend("Alice");
        final Friend bob = new Friend("Bob");

        new Thread(() -> alice.bow(bob)).start();

        new Thread(() -> bob.bow(alice)).start();
    }
}
