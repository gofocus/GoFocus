package Ch5;

/**
 * @Author: gofocus
 * @Date: 11:01 2018/3/15 0015
 */
public class E06 {
    public static void main(String[] args) {
        Dog2 dog2 = new Dog2();
        dog2.bark(1, 1.1);
        dog2.bark(1.1,1);

    }


}


class Dog2 {
    public void bark(int i, double d) {
        System.out.println("int,double bark");
    }

    public void bark(double d, int i) {
        System.out.println("double,int bark");
    }
}

