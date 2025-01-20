package org.example.PrintNumberFrom1to100;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);
        for(int i = 1;i<=1000000; i++)
        {
            NumberPrinter x1 = new NumberPrinter(i);
            es.execute(x1);



        }
    }
}
