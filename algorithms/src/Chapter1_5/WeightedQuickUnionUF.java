package Chapter1_5;

/**
 * Created by
 *
 * @Author: gofocus
 * @Date: 10:36 2018/3/17 0017
 */


public class WeightedQuickUnionUF {
    private int[] sz;
    private int[] id;
    private int count;

    public WeightedQuickUnionUF(int N) {
        this.count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int getCount() {
        return count;
    }

    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        if (!connected(p, q)) {
            if (sz[p] <= sz[q]) {
                id[p] = q;
                sz[q] += sz[p];
            } else {
                id[q] = p;
                sz[p] += sz[q];
            }
            count--;
        }

    }
/*    public void union(int p, int q) {

        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (sz[rootP] <= sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
        count--;


    }*/



}


