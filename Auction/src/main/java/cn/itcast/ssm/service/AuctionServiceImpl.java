package cn.itcast.ssm.service;

import cn.itcast.ssm.mapper.AuctionMapper;
import cn.itcast.ssm.mapper.AuctionMapperCustom;
import cn.itcast.ssm.po.Auction;
import cn.itcast.ssm.po.AuctionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gofocus
 * @Date: 23:02 2019/8/23
 */
@Service
public class AuctionServiceImpl implements AuctionService {
    @Autowired
    private AuctionMapper auctionMapper;

    @Autowired
    private AuctionMapperCustom auctionMapperCustom;

/*    @Override
    public List<Auction> getAutcionHistory() {
//        return auctionMapper.selectByExample(new AuctionExample());
        return auctionMapper.selectByPrimaryKey(1);
    }    */

    @Override
    public List<Auction> getAutcionHistory() {
        AuctionExample auctionExample = new AuctionExample();
//        auctionExample.createCriteria().add
//        return auctionMapper.selectByExample(new AuctionExample());
        return auctionMapper.selectByExample(auctionExample);
    }

    @Override
    public void insert(Auction record) {
        auctionMapper.insertSelective(record);
    }

    @Override
    public void deal(Auction record) {
        auctionMapper.updateByPrimaryKeySelective(record);
    }


}
