package com.nkp.dao;

import com.nkp.pojo.Cooperation;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CooperationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation
     *
     * @mbggenerated
     */
    int insert(Cooperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation
     *
     * @mbggenerated
     */
    int insertSelective(Cooperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation
     *
     * @mbggenerated
     */
    Cooperation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Cooperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Cooperation record);
    @Select("select * from cooperation")
    List<Cooperation> selAll();
}