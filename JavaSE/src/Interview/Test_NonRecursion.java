package Interview;

/**
 * Created by gofocus on 2017/6/2616:10.
 */

//用非递归方法计算斐波那契数列中第40个数的值
//    102334155
public class Test_NonRecursion {
    public static void main(String[] args) {
        int i,j,num,m=0;
        for (i=1,j=1,num=2;num<40;num++){
            m=i+j;
            i=j;
            j=m;
        }
        System.out.println(m);
    }


}
