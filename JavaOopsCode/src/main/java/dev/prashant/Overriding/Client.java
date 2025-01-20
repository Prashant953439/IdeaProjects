package dev.prashant.Overriding;

public class Client {
    public static void main(String[] args) {
        {
            A a = new A();
            a.doSomething("asdsdf");

            B b = new B();
            b.doSomething("sdfsfsdf");

            A a1 = new B();
            a1.doSomething("dfdrgg");

            A obj = new C();
            obj.doSomething("sdfsdg");
            

        }
    }
}
