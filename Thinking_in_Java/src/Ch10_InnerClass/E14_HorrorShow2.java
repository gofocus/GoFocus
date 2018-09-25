package Ch10_InnerClass;

/**
 * @Author: gofocus
 * @Date: 9:47 2018/3/31 0031
 */



/****************** Exercise 14 ******************
 * Modify interfaces/HorrorShow.java to implement
 * DangerousMonster and Vampire using anonymous
 * classes.
 ************************************************/

public class E14_HorrorShow2 {

    public static void main(String[] args) {
        DangerousMonster barney = new DangerousMonster(){

            @Override
            public void destroy() {

            }

            @Override
            public void menace() {

            }
        };
        HorrorShow.v(barney);
        HorrorShow.u(barney);

        Vampire vampire = new Vampire(){

            @Override
            public void drinkBlood() {

            }

            @Override
            public void kill() {

            }

            @Override
            public void destroy() {

            }

            @Override
            public void menace() {

            }
        };



    }
}
