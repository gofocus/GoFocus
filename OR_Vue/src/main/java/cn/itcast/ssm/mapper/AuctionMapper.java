package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.Auction;
import cn.itcast.ssm.po.AuctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuctionMapper {
    long countByExample(AuctionExample example);

    int deleteByExample(AuctionExample example);

    int insert(Auction record);

    int insertSelective(Auction record);

    List<Auction> selectByExample(AuctionExample example);

    int updateByExampleSelective(@Param("record") Auction record, @Param("example") AuctionExample example);

    int updateByExample(@Param("record") Auction record, @Param("example") AuctionExample example);
}