package Ch9;

interface Service {
    void method1();

    void method2();
}

class Impl1 implements Service {

    @Override
    public void method1() {
        System.out.println("impl1 method1");
    }

    @Override
    public void method2() {
        System.out.println("impl1 method2");
    }
}

class Impl2 implements Service {

    @Override
    public void method1() {
        System.out.println("impl2 method1");
    }

    @Override
    public void method2() {
        System.out.println("impl2 method2");
    }
}

public class Test {

    public static void serviceConsumer(Service service) {
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Impl1());
        serviceConsumer(new Impl2());
    }

}











