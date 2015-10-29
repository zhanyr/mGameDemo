package com.zyr.demo.dao;

import com.zyr.demo.bean.DemoUser;
import com.zyr.demo.bean.DemoUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DemoUserMapper {
	
	int addUser(DemoUser demoUser);
	
    int countByExample(DemoUserExample example);

    int deleteByExample(DemoUserExample example);

    @Delete({
        "delete from demo_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into demo_user (id, user_name, ",
        "password, role, enabled, ",
        "score)",
        "values (#{id,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{role,jdbcType=CHAR}, #{enabled,jdbcType=CHAR}, ",
        "#{score,jdbcType=INTEGER})"
    })
    int insert(DemoUser record);

    int insertSelective(DemoUser record);

    List<DemoUser> selectByExample(DemoUserExample example);

    @Select({
        "select",
        "id, user_name, password, role, enabled, score",
        "from demo_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    DemoUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoUser record, @Param("example") DemoUserExample example);

    int updateByExample(@Param("record") DemoUser record, @Param("example") DemoUserExample example);

    int updateByPrimaryKeySelective(DemoUser record);

    @Update({
        "update demo_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "role = #{role,jdbcType=CHAR},",
          "enabled = #{enabled,jdbcType=CHAR},",
          "score = #{score,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DemoUser record);
}