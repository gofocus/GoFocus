package cn.itcast.ssm.po;

/**
 * @Author: gofocus
 * @Date: 8:28 2019/8/25
 */
public class Bid {
//    private int auctionId;
    private int userId;
    private int bidPoint;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBidPoint() {
        return bidPoint;
    }

    public void setBidPoint(int bidPoint) {
        this.bidPoint = bidPoint;
    }


}
