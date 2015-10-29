package com.zyr.demo.dao;

import com.zyr.demo.bean.DemoGiftKey;
import com.zyr.demo.bean.DemoGiftKeyExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DemoGiftKeyMapper {
    int countByExample(DemoGiftKeyExample example);

    int deleteByExample(DemoGiftKeyExample example);

    @Delete({
        "delete from demo_gift_key",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into demo_gift_key (id, gift_id, ",
        "gift_key, gift_status)",
        "values (#{id,jdbcType=INTEGER}, #{giftId,jdbcType=INTEGER}, ",
        "#{giftKey,jdbcType=VARCHAR}, #{giftStatus,jdbcType=CHAR})"
    })
    int insert(DemoGiftKey record);

    int insertSelective(DemoGiftKey record);

    List<DemoGiftKey> selectByExample(DemoGiftKeyExample example);

    @Select({
        "select",
        "id, gift_id, gift_key, gift_status",
        "from demo_gift_key",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    DemoGiftKey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoGiftKey record, @Param("example") DemoGiftKeyExample example);

    int updateByExample(@Param("record") DemoGiftKey record, @Param("example") DemoGiftKeyExample example);

    int updateByPrimaryKeySelective(DemoGiftKey record);

    @Update({
        "update demo_gift_key",
        "set gift_id = #{giftId,jdbcType=INTEGER},",
          "gift_key = #{giftKey,jdbcType=VARCHAR},",
          "gift_status = #{giftStatus,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DemoGiftKey record);
}