package org.example.PrintNumberFrom1to100;

public class NumberPrinter implements Runnable {
    int numbertoPrint;

  NumberPrinter(int numbertoPrint) {
  this.numbertoPrint = numbertoPrint;
  }

    @Override
    public void run() {
        System.out.println(numbertoPrint + " " + Thread.currentThread().getName());
    }
}