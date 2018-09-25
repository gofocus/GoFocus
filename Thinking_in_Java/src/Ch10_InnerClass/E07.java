package Ch10_InnerClass;

/**
 * @Author: gofocus
 * @Date: 10:58 2018/3/30 0030
 */

/****************** Exercise 7 *****************
 * Create a class with a private field and a
 * private method. Create an inner class with a
 * method that modifies the outer-class field and
 * calls the outer-class method. In a second
 * outer-class method, create an object of the
 * inner class and call its method, then show
 * the effect on the outer-class object.
 ***********************************************/

/*This exercise shows that inner classes have transparent access to their outerclass
        objects, even private fields and methods.*/
public class E07 {
    private int i = 1;
    private void alert() {
        System.out.println(i);
    }

    class Inner {
        void innerFunc() {
            i++;
            alert();
        }
    }


    void outerFunc() {
        Inner inner = new Inner();
        inner.innerFunc();
    }


    public static void main(String[] args) {
        E07 e07 = new E07();
        e07.outerFunc();
    }

}
