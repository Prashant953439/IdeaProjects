package dev.prashant.MethodOverloadingOverriding;

public class Thread extends Point{
    private int z;

    @Override
    public void display() {
        System.out.println("["+ "x" + "y" + "z" + "]");
    }
}
