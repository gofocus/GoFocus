package cn.itcast.ssm.po;

import java.util.Date;

public class Auction {
    private String gear;

    private String auctioneer;

    private Integer highestBid;

    private Integer secondBid;

    private String successfulBidder;

    private Date auctionTime;

    private Integer id;

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear == null ? null : gear.trim();
    }

    public String getAuctioneer() {
        return auctioneer;
    }

    public void setAuctioneer(String auctioneer) {
        this.auctioneer = auctioneer == null ? null : auctioneer.trim();
    }

    public Integer getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Integer highestBid) {
        this.highestBid = highestBid;
    }

    public Integer getSecondBid() {
        return secondBid;
    }

    public void setSecondBid(Integer secondBid) {
        this.secondBid = secondBid;
    }

    public String getSuccessfulBidder() {
        return successfulBidder;
    }

    public void setSuccessfulBidder(String successfulBidder) {
        this.successfulBidder = successfulBidder == null ? null : successfulBidder.trim();
    }

    public Date getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(Date auctionTime) {
        this.auctionTime = auctionTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}