package org.example.IntroToThreads;

public class  Client {
    public static void main(String[] args) {
        System.out.println("Hello World printed by" + Thread.currentThread().getName());

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        Thread thread = new Thread(helloWorldPrinter);
        thread.start();

        System.out.println("Hello World printed by" + Thread.currentThread().getName());

    }
}
