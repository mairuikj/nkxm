package com.nkp.dao;

import com.nkp.pojo.News;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface NewsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer newsid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated
     */
    int insert(News record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated
     */
    int insertSelective(News record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated
     */
    News selectByPrimaryKey(Integer newsid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(News record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(News record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(News record);
    @Select("select * from news ORDER BY newsId DESC")
    List<News> selAll();

    @Select("select * from news where newsType=#{typeid}")
    List<News> selByTypeId(Integer typeid);

    List<News> selNewsAndNewsType(@Param("id") Integer id);
    @Update("update news set remarks='1' where newsId=#{id}")
    int hide(Integer id);
    @Select("select * from news where newsId in (${str}) order by find_in_set (newsId,'${str}')")
    List<News> hb(@Param("str") String str);

    @Select("select * from news where newsType=#{newsType} and remarks='0' order by creatTime desc")
    List<News> byType(@Param("newsType") Integer newsType);

    List<News> selNewsAndAuthor();

    //手机端详情
    News selectByPrimaryKey2(@Param("id")Integer newsid);
    //相似新闻
    @Select("${sql2}")
    List<News> exqt(@Param("sql2")String sql2);
    @Select("select newsId,title,creatTime,topPicture from news where newsId in ${temp} order by find_in_set (newsId,'${temp1}')")
    List<News> resof(@Param("temp") String temp,@Param("temp1") String temp1);
    @Select("select * from news where author=#{id}")
    List<News> getNews(Integer id);

    @Select("select * from news where title like '%${str}%' or keyWord like '%${str}%'")
    List<News> like(@Param("str") String str);

    @Select("select keyWord from news where newsId in (${str}) order by find_in_set (newsId,'${str}')")
    List<News> hb1(@Param("str") String str);


    @Update("update news set remarks=#{flag} where newsId=#{id}")
    int hide1(Integer id,Integer flag);

    @Update("update news set creatTime=#{dateTime} where newsId=#{id}")
    int roof(Integer id, Date dateTime);
    //此作者发布了多少新闻
    @Select("SELECT COUNT(*) from news GROUP BY author HAVING author=#{id}")
    Integer selByAuthor(Integer id);
}