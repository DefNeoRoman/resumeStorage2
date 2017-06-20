package com.sandBox.workingExamples;

public class TestSingleton {
    private static TestSingleton ourInstance;
    double sin = Math.sin(13.);
    public static synchronized TestSingleton getInstance() {
        if(ourInstance == null){ //Ленивая инициализация
            synchronized (TestSingleton.class){ // double check locking
                if(ourInstance == null){
                    ourInstance = new TestSingleton();
                }
            }

        }
        return ourInstance;// Эта конструкция не работает при многопоточности
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {

        }
    public enum Singleton{
        INSTANCE
    }
}
