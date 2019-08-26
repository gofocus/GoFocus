package cn.itcast.ssm.service;

import cn.itcast.ssm.po.Auction;

import java.util.List;

/**
 * @Author: gofocus
 * @Date: 23:01 2019/8/23
 */
public interface AuctionService {

//    List<Auction> getAutcionHistory();
    List<Auction> getAutcionHistory();

    void insert(Auction record);

    void deal(Auction record);

}
