package Chapter1_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author: gofocus
 * @Date: 15:32 2018/3/17 0017
 * Social network connectivity. Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be mlogn or better and use extra space proportional to n.
 */
public class SocialNetWorkConnUF {
    private FileInputStream fis;
    private WeightedQuickUnionUF wquf;

    public SocialNetWorkConnUF(int N, FileInputStream fis) {
        this.fis = fis;
        wquf = new WeightedQuickUnionUF(N);
    }

    public String getEarliestConTime() {
        Scanner scanner = new Scanner(fis, "utf-8");
        String earliestConTime = null;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line != null && !line.trim().equals("")) {
                String lineArray[] = line.split(" ");
                if (lineArray.length == 3) {
                    String timestamp = lineArray[0];
                    int p = Integer.parseInt(lineArray[1]);
                    int q = Integer.parseInt(lineArray[2]);
                    wquf.union(p, q);
                    if (wquf.getCount() == 1) {
                        earliestConTime = timestamp;
                        break;
                    }
                }
            }
        }
        return earliestConTime;
    }

    public static void main(String[] args) {
        FileInputStream fis;
        try {
//            fis = new FileInputStream("../socialNetworkLog.txt");
            fis = new FileInputStream("D:\\java\\svn\\test_gj\\algorithms\\src\\Chapter1_5\\socialNetworkLog.txt");
            SocialNetWorkConnUF suf = new SocialNetWorkConnUF(10, fis);
            String earliestConnTime = suf.getEarliestConTime();
            System.out.println(earliestConnTime);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
