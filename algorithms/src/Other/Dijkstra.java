package Other;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;

//无向图求最短路径
public class Dijkstra {
    private static Scanner sc;
    private static final int inf = Integer.MAX_VALUE;//表示两个点之间无法直接连通


    public static void display(String[] mapping) {
        for (int i = 0; i < 11; i++) {
            System.out.print(i + "." + mapping[i] + " ");
        }
        System.out.println();
    }

    public static int usrIO() {
        System.out.println("请输入当前位置（数字）:");
        int origin = 0;
        sc = new Scanner(System.in);
        String sc0str = sc.next();
        int sc0str_int;
        Pattern pattern = Pattern.compile("[0-9]*");
        if (pattern.matcher(sc0str).matches()) {
            sc0str_int = Integer.parseInt(sc0str);
            if (sc0str_int >= 0 && sc0str_int <= 10) return sc0str_int;
            else {
                System.out.println("输入有误");
                origin = 255;
                return origin;
            }
        } else {
            System.out.println("输入有误");
            origin = 255;
            return origin;
        }
    }

    public static int search() {
        System.out.println("请输入要查找的点的号码");
        String sc1str;
        InputStreamReader bf = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(bf);
        try {
            sc1str = br.readLine();
            return Integer.parseInt(sc1str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("号码无效！");
            e.printStackTrace();
            return 255;
        }
    }

    public static void outputInfo(String[][] info, int num){
        for (int i = 0; i < 11; i++) {
            if (num == Integer.parseInt(info[i][0])) {
                System.out.print(info[i][1]);
                System.out.println(info[i][2]);
            }
        }
        route(mapOrInfo());
    }

    //选择查询景点信息或最短路径
    public static int mapOrInfo(){
        System.out.println("查看信息(输入数字) or 查找最短路径(输入任意字符)");
        int c0;
        String sc2str = "";
        InputStreamReader bf0 = new InputStreamReader(System.in);
        BufferedReader br0 = new BufferedReader(bf0);
        try {
            sc2str = br0.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        if (pattern.matcher(sc2str).matches())
            c0 = 1;
        else
            c0 = 2;
        return c0;
    }

    public static int[] dijkstra(int[][] graph, int n, int u) {
        int dist[] = new int[n];
        boolean s[] = new boolean[n];
        String[] path = new String[n];

        Arrays.fill(s, false);
        Arrays.fill(dist, inf);

        int min, v;

        for (int i = 0; i < n; i++) {
            dist[i] = graph[u][i];
            path[i] =  realnameMapping[u] + "-->" + realnameMapping[i];
        }

        s[u] = true;
        while (true) {
            min = inf;
            v = -1;

            //找到最小的dist
            for (int i = 0; i < n; i++) {
                if (!s[i]) {
                    if (dist[i] < min) {
                        min = dist[i];
                        v = i;
                    }
                }
            }
            if (v == -1) break;

            // 更新最短路径
            s[v] = true;
            for (int i = 0; i < n; i++) {
                if (!s[i] && graph[v][i] != inf && (dist[v] + graph[v][i] < dist[i])) {
                    dist[i] = dist[v] + graph[v][i];
                    path[i] = path[v] + "-->" + realnameMapping[i];
                }
            }
        }

        //输出路径
        String str = realnameMapping[u];
        System.out.println("以" + str + "为起点的最短路径为:");
        for (int i = 0; i < n; i++) {
            if (dist[i] != inf) {
                System.out.println(path[i] + "=" + dist[i]);
            }
        }

        return dist;
    }

    public static void route(int c0){
        if (c0 == 2) {
            int[][] W = {
                    {0, 7, inf, 1, 2, inf,inf,inf,inf,inf,inf},
                    {7, 0, 7, inf, 6, inf,inf,inf,inf,inf,inf},
                    {inf, 7, 0, inf, inf, 7,inf,inf,inf,inf,inf},
                    {1, inf, inf, 0, 1, inf,1,inf,inf,inf,inf},
                    {2, 6, inf, 1, 0, 6,3,inf,inf,inf,inf},
                    {inf, inf, 7, inf, 6, 0,inf,8,inf,inf,inf},
                    {inf, inf, inf, 1, 3, inf,0,9,6,inf,inf},
                    {inf, inf, inf, inf, inf, 8,9,0,7,inf,3},
                    {inf, inf, inf, inf, inf, inf,6,7,0,1,inf},
                    {inf, inf, inf, inf, inf, inf,inf,inf,1,0,8},
                    {inf, inf, inf, inf, inf, inf,inf,3,inf,8,0}
            };
            dijkstra(W, 11, usrIO());
        } else if (c0 == 1) {
            outputInfo(infoSheet(realnameMapping), search());
        }
        route(mapOrInfo());
    }

    public static void overall(){
        display(realnameMapping);
        route(mapOrInfo());
    }

    public static void main(String[] args) {
        overall();
        sc.close();
    }

    public static String realnameMapping[] = {"学院楼", "体育馆", "师活中心", "航飞楼", "图书馆", "艺术楼", "实训楼", "教学楼", "行政楼", "东门", "一食堂"};

    public static String[][] infoSheet(String[] nameMap) {
        String[][] info = new String[11][3];
        for (int i = 0; i < 11; i++) {
            info[i][0] = String.valueOf(i);
            info[i][1] = nameMap[i];
            info[i][2] = "............信息..............";
        }
        return info;
    }

    public static int[][] originMatrix() {
        int[][] matrix = new int[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                matrix[i][j] = 255;
            }
        }
        for (int i = 0; i < 11; i++) {
            matrix[i][i] = 0;
        }
        matrix[0][1] = 7;
        matrix[0][3] = 1;
        matrix[0][4] = 2;
        matrix[1][2] = 7;
        matrix[1][4] = 6;
        matrix[2][5] = 7;
        matrix[3][4] = 1;
        matrix[4][5] = 6;
        matrix[4][6] = 3;
        matrix[5][7] = 8;
        matrix[6][7] = 9;
        matrix[6][8] = 6;
        matrix[7][8] = 7;
        matrix[7][10] = 3;
        matrix[8][9] = 1;
        matrix[9][10] = 8;
        for (int i = 0; i < 11; i++) {
            for (int j = i; j < 11; j++) {
                if (matrix[i][j] != 255) {
                    matrix[j][i] = matrix[i][j];
                }
            }
        }
        return matrix;
    }

}