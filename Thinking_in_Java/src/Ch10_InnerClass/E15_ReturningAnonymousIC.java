package Ch10_InnerClass;

/**
 * @Author: gofocus
 * @Date: 10:08 2018/3/31 0031
 */

/****************** Exercise 15 *****************
 * Create a class with a non-default constructor
 * (one with arguments) and no default constructor
 * (no "no-arg" constructor). Create a second class
 * with a method that returns a reference to
 * an object of the first class. Create the object
 * you return by making an anonymous inner
 * class inherit from the first class.
 ***********************************************/

/*In get1( ), you inherit NoDefault in the anonymous inner class without
overriding any methods; usually you’ll override a method when you inherit, as in
get2( ). */

class NoDefault {
    private int i;
    public NoDefault(int i) {
        this.i = i;
    }
    public void f() { System.out.println("NoDefault.f"); }
}

class Second {
    public NoDefault get1(int i) {
        // Doesn't override any methods:
        return new NoDefault(i){};
    }

    public NoDefault get2(int i) {
        // Overrides f():
        return new NoDefault(i) {
            public void f() {
                System.out.println("Second.get2.f");
            }
        };
    }
}



public class E15_ReturningAnonymousIC {
    public static void main(String[] args) {
        Second second = new Second();
        NoDefault noDefault = second.get1(10);
        noDefault.f();
        noDefault = second.get2(50);
        noDefault.f();
    }

}

