package com.nkp.dao;

import com.nkp.pojo.Shrio;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ShrioMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shrio
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shrio
     *
     * @mbggenerated
     */
    int insert(Shrio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shrio
     *
     * @mbggenerated
     */
    int insertSelective(Shrio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shrio
     *
     * @mbggenerated
     */
    Shrio selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shrio
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Shrio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shrio
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Shrio record);
    @Delete("delete from shrio where uid=#{uid}")
    int delShrio(int uid);

    //查看此用户是否有此URL的访问权限
    Shrio selectByUrl(@Param("map")Map<String,Object> map);
    //权限回显
    @Select("select * from shrio where uid=#{id}")
    List<Shrio> selByuid(@Param("id") Integer id);
}