package com.nkp.pojo;

import java.util.Date;

public class UserInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userInfo.userId
     *
     * @mbggenerated
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userInfo.userName
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userInfo.userPW
     *
     * @mbggenerated
     */
    private String userpw;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userInfo.userPhone
     *
     * @mbggenerated
     */
    private String userphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userInfo.purl
     *
     * @mbggenerated
     */
    private String purl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userInfo.createTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userInfo.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userInfo.userId
     *
     * @return the value of userInfo.userId
     *
     * @mbggenerated
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userInfo.userId
     *
     * @param userid the value for userInfo.userId
     *
     * @mbggenerated
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userInfo.userName
     *
     * @return the value of userInfo.userName
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userInfo.userName
     *
     * @param username the value for userInfo.userName
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userInfo.userPW
     *
     * @return the value of userInfo.userPW
     *
     * @mbggenerated
     */
    public String getUserpw() {
        return userpw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userInfo.userPW
     *
     * @param userpw the value for userInfo.userPW
     *
     * @mbggenerated
     */
    public void setUserpw(String userpw) {
        this.userpw = userpw == null ? null : userpw.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userInfo.userPhone
     *
     * @return the value of userInfo.userPhone
     *
     * @mbggenerated
     */
    public String getUserphone() {
        return userphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userInfo.userPhone
     *
     * @param userphone the value for userInfo.userPhone
     *
     * @mbggenerated
     */
    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userInfo.purl
     *
     * @return the value of userInfo.purl
     *
     * @mbggenerated
     */
    public String getPurl() {
        return purl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userInfo.purl
     *
     * @param purl the value for userInfo.purl
     *
     * @mbggenerated
     */
    public void setPurl(String purl) {
        this.purl = purl == null ? null : purl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userInfo.createTime
     *
     * @return the value of userInfo.createTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userInfo.createTime
     *
     * @param createtime the value for userInfo.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userInfo.type
     *
     * @return the value of userInfo.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userInfo.type
     *
     * @param type the value for userInfo.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }
}