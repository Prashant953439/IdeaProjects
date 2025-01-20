package dev.prashant.Overriding;

public class C extends A{
    @Override
    public void doSomething(String s) {
        System.out.println("Calling from C");
    }
}
