package Ch10_InnerClass;

import Ch5.SimpleInterface;
import Ch9.SimpleClass;

/**
 * @Author: gofocus
 * @Date: 10:27 2018/3/30 0030
 */

/*You cannot access the synthesized default constructor from
        E06 ProtectedInnerClass because it has the same protected access as the
        defining class.*/

public class E06_ProtectedInnerClass extends SimpleClass {

    public SimpleInterface get() {
        return new Inner();
    }

    public static void main(String[] args) {
        new E06_ProtectedInnerClass().get().f();
    }

}
