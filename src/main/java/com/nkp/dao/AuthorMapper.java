package com.nkp.dao;

import com.nkp.pojo.Author;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuthorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbggenerated
     */
    int insert(Author record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbggenerated
     */
    int insertSelective(Author record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbggenerated
     */
    Author selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Author record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Author record);
    @Select("select * from author")
    List<Author> selAll();
    @Select("select * from author where id=#{id}")
    Author selectByPrimaryKey1(int id);
}