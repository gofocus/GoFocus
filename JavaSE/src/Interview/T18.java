package Interview;

/**
 * @Author: gofocus
 * @Date: 15:46 2018/8/8 0008
 */
public class T18 {
    int i = 10;

    static class Child extends T18 {
        int j = 2;

        public Child() {
            System.out.println(super.i);    // 10
//            System.out.println(super);      // 报错了，说明根本不存在父类对象
            System.out.println(this);       // Interview.T18$Child@1540e19d
            System.out.println(this.i);     // 10
            System.out.println(this.j);     // 2
        }

        public static void main(String[] args) {
            new Child();
        }

    }
}
