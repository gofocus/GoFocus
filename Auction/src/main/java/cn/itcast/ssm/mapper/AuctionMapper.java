package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.Auction;
import cn.itcast.ssm.po.AuctionExample;
import org.apache.ibatis.annotations.Param;

public interface AuctionMapper {
    long countByExample(AuctionExample example);

    int deleteByExample(AuctionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Auction record);

    int insertSelective(Auction record);

    List<Auction> selectByExample(AuctionExample example);

    Auction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Auction record, @Param("example") AuctionExample example);

    int updateByExample(@Param("record") Auction record, @Param("example") AuctionExample example);

    int updateByPrimaryKeySelective(Auction record);

    int updateByPrimaryKey(Auction record);
}