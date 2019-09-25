package com.nkp.pojo;

import java.util.Date;

public class Activity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activityTime
     *
     * @mbggenerated
     */
    private Date activitytime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activityAddress
     *
     * @mbggenerated
     */
    private String activityaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.endTime
     *
     * @mbggenerated
     */
    private Date endtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activityPictures
     *
     * @mbggenerated
     */
    private String activitypictures;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.price
     *
     * @mbggenerated
     */
    private String price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.remarks
     *
     * @mbggenerated
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.id
     *
     * @return the value of activity.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.id
     *
     * @param id the value for activity.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.name
     *
     * @return the value of activity.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.name
     *
     * @param name the value for activity.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activityTime
     *
     * @return the value of activity.activityTime
     *
     * @mbggenerated
     */
    public Date getActivitytime() {
        return activitytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activityTime
     *
     * @param activitytime the value for activity.activityTime
     *
     * @mbggenerated
     */
    public void setActivitytime(Date activitytime) {
        this.activitytime = activitytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activityAddress
     *
     * @return the value of activity.activityAddress
     *
     * @mbggenerated
     */
    public String getActivityaddress() {
        return activityaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activityAddress
     *
     * @param activityaddress the value for activity.activityAddress
     *
     * @mbggenerated
     */
    public void setActivityaddress(String activityaddress) {
        this.activityaddress = activityaddress == null ? null : activityaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.endTime
     *
     * @return the value of activity.endTime
     *
     * @mbggenerated
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.endTime
     *
     * @param endtime the value for activity.endTime
     *
     * @mbggenerated
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activityPictures
     *
     * @return the value of activity.activityPictures
     *
     * @mbggenerated
     */
    public String getActivitypictures() {
        return activitypictures;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activityPictures
     *
     * @param activitypictures the value for activity.activityPictures
     *
     * @mbggenerated
     */
    public void setActivitypictures(String activitypictures) {
        this.activitypictures = activitypictures == null ? null : activitypictures.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.price
     *
     * @return the value of activity.price
     *
     * @mbggenerated
     */
    public String getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.price
     *
     * @param price the value for activity.price
     *
     * @mbggenerated
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.remarks
     *
     * @return the value of activity.remarks
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.remarks
     *
     * @param remarks the value for activity.remarks
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.content
     *
     * @return the value of activity.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.content
     *
     * @param content the value for activity.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}