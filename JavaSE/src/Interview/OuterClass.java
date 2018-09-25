package Interview;

/**
 * @Author: gofocus
 * @Date: 19:08 2018/7/15 0015
 */
public class OuterClass {

     static int anInt = 10;

    class InnerClass {
        void func() {
         anInt = 20;
//            OuterClass.this.anInt = 20;
        }
    }

    static class staticInnerClass {

        static {
            anInt = 20;
        }

    }



    void func() {                                  //非静态方法
        InnerClass a = new InnerClass();
        staticInnerClass b = new staticInnerClass();
    }


    public static void main(String[] args) {       //静态方法
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();

        staticInnerClass innerClass2 = new staticInnerClass();

        System.out.println(outerClass.anInt);

    }

}
