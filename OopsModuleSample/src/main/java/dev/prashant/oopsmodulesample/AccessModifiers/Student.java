package dev.prashant.oopsmodulesample.AccessModifiers;

public class Student {
    public String name;

    int age;
    protected double psp;
    private String univName;

    public void doSomething() {
        name = "Mohit";
        age = 10;
        psp = 85;
        univName = "wbut";

        Student student = new Student();
        student.name = "Rohit";
        student.age = 20;
        student.psp = 90.00;
        student.univName = "kit";
    }
}
