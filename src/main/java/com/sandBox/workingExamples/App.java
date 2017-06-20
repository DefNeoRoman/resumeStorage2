package com.sandBox.workingExamples;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();

    }
}

class Pet{
    public Pet() {
        System.out.println("I am Pet");
    }
}

class Cat extends Pet {
    public Cat() {
        System.out.println("i am Cat");
    }
}
