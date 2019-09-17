package com.nkp.pojo;

import java.util.Date;

public class News {
    private NewsType newsType;
    private Author author1;

    public NewsType getNewsType() {
        return newsType;
    }

    public Author getAuthor1() {
        return author1;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    public void setAuthor1(Author author1) {
        this.author1 = author1;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.newsId
     *
     * @mbggenerated
     */
    private Integer newsid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.newsType
     *
     * @mbggenerated
     */
    private Integer newstype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.author
     *
     * @mbggenerated
     */
    private Integer author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.creatTime
     *
     * @mbggenerated
     */
    private Date creattime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.topPicture
     *
     * @mbggenerated
     */
    private String toppicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.keyWord
     *
     * @mbggenerated
     */
    private String keyword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.remarks
     *
     * @mbggenerated
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.newsId
     *
     * @return the value of news.newsId
     *
     * @mbggenerated
     */
    public Integer getNewsid() {
        return newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.newsId
     *
     * @param newsid the value for news.newsId
     *
     * @mbggenerated
     */
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.newsType
     *
     * @return the value of news.newsType
     *
     * @mbggenerated
     */
    public Integer getNewstype() {
        return newstype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.newsType
     *
     * @param newstype the value for news.newsType
     *
     * @mbggenerated
     */
    public void setNewstype(Integer newstype) {
        this.newstype = newstype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.title
     *
     * @return the value of news.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.title
     *
     * @param title the value for news.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.author
     *
     * @return the value of news.author
     *
     * @mbggenerated
     */
    public Integer getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.author
     *
     * @param author the value for news.author
     *
     * @mbggenerated
     */
    public void setAuthor(Integer author) {
        this.author = author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.creatTime
     *
     * @return the value of news.creatTime
     *
     * @mbggenerated
     */
    public Date getCreattime() {
        return creattime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.creatTime
     *
     * @param creattime the value for news.creatTime
     *
     * @mbggenerated
     */
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.topPicture
     *
     * @return the value of news.topPicture
     *
     * @mbggenerated
     */
    public String getToppicture() {
        return toppicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.topPicture
     *
     * @param toppicture the value for news.topPicture
     *
     * @mbggenerated
     */
    public void setToppicture(String toppicture) {
        this.toppicture = toppicture == null ? null : toppicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.keyWord
     *
     * @return the value of news.keyWord
     *
     * @mbggenerated
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.keyWord
     *
     * @param keyword the value for news.keyWord
     *
     * @mbggenerated
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.remarks
     *
     * @return the value of news.remarks
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.remarks
     *
     * @param remarks the value for news.remarks
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.content
     *
     * @return the value of news.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.content
     *
     * @param content the value for news.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}