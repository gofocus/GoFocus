/**
 * Created by gofocus on 2017/6/261:32.
 */

//输出1-100内前五个可以被3整除的数
public class While_Test {

    /*public static void main(String[] args) {
        int num=0 ;
        for(int i=1;i<100; i+=2)
        {
            if(i%3==0){
                System.out.println(i);
                num++;
            }

            while (num>=5) break;
        }
    }*/


    public static void main(String[] args) {
        int num=0;
        int i=1;
        while (i<100){
            if(i%3==0) {
                System.out.println(i);
                num++;
            }
            if (num>=5) break;
            i++;
        }
    }

}
