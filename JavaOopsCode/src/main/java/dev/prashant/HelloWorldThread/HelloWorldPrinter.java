package dev.prashant.HelloWorldThread;

public class HelloWorldPrinter implements Runnable{
    @Override
    public void run(){
        System.out.println("Printing hello World from " + Thread.currentThread().getName());
    }
}
