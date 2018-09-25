package Chapter1_3;

/**
 * Created by GoFoCus $on 2017/7/20.
 */
public class Test {

    private int t;

    public int change(){
        int t = 1;              //此处的t为局部变量，对局部变量操作，对成员变量t没有影响
        System.out.println(t);
        return t;
    }

    int getT() {
        return t;
    }
}

class T{
    public static void main(String[] args) {
        Test test = new Test();
        test.change();                   //输出1，t的值取最近的变量局部变量
        System.out.println(test.getT()); //输出0
    }
}