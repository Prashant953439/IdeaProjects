package org.example.IntroToThreads;

public class HelloWorldPrinter implements Runnable{


    @Override
    public void run() {
        System.out.println("Hello World Printey by "+ Thread.currentThread().getName());
    }
}

