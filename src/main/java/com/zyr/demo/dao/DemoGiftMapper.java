package com.zyr.demo.dao;

import com.zyr.demo.bean.DemoGift;
import com.zyr.demo.bean.DemoGiftExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DemoGiftMapper {
    int countByExample(DemoGiftExample example);

    int deleteByExample(DemoGiftExample example);

    @Delete({
        "delete from demo_gift",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into demo_gift (id, gift_name, ",
        "start_time, end_time, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{giftName,jdbcType=VARCHAR}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(DemoGift record);

    int insertSelective(DemoGift record);

    List<DemoGift> selectByExample(DemoGiftExample example);

    @Select({
        "select",
        "id, gift_name, start_time, end_time, description",
        "from demo_gift",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    DemoGift selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoGift record, @Param("example") DemoGiftExample example);

    int updateByExample(@Param("record") DemoGift record, @Param("example") DemoGiftExample example);

    int updateByPrimaryKeySelective(DemoGift record);

    @Update({
        "update demo_gift",
        "set gift_name = #{giftName,jdbcType=VARCHAR},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DemoGift record);
}