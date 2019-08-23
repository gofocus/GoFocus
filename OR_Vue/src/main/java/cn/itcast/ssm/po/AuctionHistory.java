package cn.itcast.ssm.po;

import java.util.Date;
import java.util.Map;

/**
 * @Author: GoFocus
 * @Date: 2019-08-23
 * @Time: 16:54
 * @Description:
 */
public class AuctionHistory {

    //装备名称
    private String gear;

    //拍卖师
    private String auctioneer;

    //最高出价
    private int highestBid;

    //第二出价
    private int secondBid;

    //中标人
    private String successfulBidder;

    //所有出价者及出价
    private Map<String, Integer> biddersAndBid;

    //拍卖时间
    private Date auctionTime;

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getAuctioneer() {
        return auctioneer;
    }

    public void setAuctioneer(String auctioneer) {
        this.auctioneer = auctioneer;
    }

    public int getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(int highestBid) {
        this.highestBid = highestBid;
    }

    public int getSecondBid() {
        return secondBid;
    }

    public void setSecondBid(int secondBid) {
        this.secondBid = secondBid;
    }

    public String getSuccessfulBidder() {
        return successfulBidder;
    }

    public void setSuccessfulBidder(String successfulBidder) {
        this.successfulBidder = successfulBidder;
    }

    public Map<String, Integer> getBiddersAndBid() {
        return biddersAndBid;
    }

    public void setBiddersAndBid(Map<String, Integer> biddersAndBid) {
        this.biddersAndBid = biddersAndBid;
    }

    public Date getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(Date auctionTime) {
        this.auctionTime = auctionTime;
    }
}
