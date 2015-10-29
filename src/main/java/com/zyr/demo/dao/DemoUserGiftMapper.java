package com.zyr.demo.dao;

import com.zyr.demo.bean.DemoUserGift;
import com.zyr.demo.bean.DemoUserGiftExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DemoUserGiftMapper {
    int countByExample(DemoUserGiftExample example);

    int deleteByExample(DemoUserGiftExample example);

    @Delete({
        "delete from demo_user_gift",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into demo_user_gift (id, user_id, ",
        "gift_id, gift_key)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{giftId,jdbcType=INTEGER}, #{giftKey,jdbcType=VARCHAR})"
    })
    int insert(DemoUserGift record);

    int insertSelective(DemoUserGift record);

    List<DemoUserGift> selectByExample(DemoUserGiftExample example);

    @Select({
        "select",
        "id, user_id, gift_id, gift_key",
        "from demo_user_gift",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    DemoUserGift selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoUserGift record, @Param("example") DemoUserGiftExample example);

    int updateByExample(@Param("record") DemoUserGift record, @Param("example") DemoUserGiftExample example);

    int updateByPrimaryKeySelective(DemoUserGift record);

    @Update({
        "update demo_user_gift",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "gift_id = #{giftId,jdbcType=INTEGER},",
          "gift_key = #{giftKey,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DemoUserGift record);
}