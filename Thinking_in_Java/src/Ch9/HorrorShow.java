package Ch9;

/**
 * @Author: gofocus
 * @Date: 9:51 2018/3/31 0031
 */
interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

public class HorrorShow {
    static void v(Monster b) {
        b.menace();
    }

    static void u(DangerousMonster d) {
        d.menace();
        d.destroy();
    }




}