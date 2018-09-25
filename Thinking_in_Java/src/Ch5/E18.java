package Ch5;

/**
 * @Author: gofocus
 * @Date: 18:47 2018/3/17 0017
 * 通过创建对象赋值给引用数组，从而完成前一个练习
 */
public class E18 {


    public static void main(String[] args) {
        Test[] a = new Test[5];

        for (int i = 0; i < 5; i++) {
            a[i] = new Test(String.valueOf(i));
        }
/*      调用了接受一个String参数的构造器
        参数为：0
        调用了接受一个String参数的构造器
        参数为：1
        调用了接受一个String参数的构造器
        参数为：2
        调用了接受一个String参数的构造器
        参数为：3
        调用了接受一个String参数的构造器
        参数为：4
*/

    }

}
