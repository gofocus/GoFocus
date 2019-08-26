package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.Guild;
import cn.itcast.ssm.po.GuildExample;
import org.apache.ibatis.annotations.Param;

public interface GuildMapper {
    long countByExample(GuildExample example);

    int deleteByExample(GuildExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Guild record);

    int insertSelective(Guild record);

    List<Guild> selectByExample(GuildExample example);

    Guild selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Guild record, @Param("example") GuildExample example);

    int updateByExample(@Param("record") Guild record, @Param("example") GuildExample example);

    int updateByPrimaryKeySelective(Guild record);

    int updateByPrimaryKey(Guild record);
}