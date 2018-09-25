package Chapter2;

/**
 * @Author: gofocus
 * @Date: 20:57 2018/4/12 0012
 */
public class BubbleSort extends Example {


    @Override
    //从小到大排序
    protected void sort(Comparable[] a) {

       /* for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (less(a[j],a[j-1])) exchange(a,j,j-1);
            }
        }*/

        for (int i = a.length; i > 0 ; i--) {
            for (int j = 1; j < i; j++) {
                if (less(a[j],a[j-1])) exchange(a,j,j-1);
            }

        }
/*
        //优化算法
        for(int i =0;i < a.length - 1;i++)
        {
            for(int j = (a.length - 2);j >= i;j--)
            {
                if (less(a[j+1], a[j])) {
                    exchange(a,j,j+1);
                }
            }
        }
*/


    }


    public static void main(String[] args) {
        new BubbleSort().sort(a);
        show(a);
    }
}
