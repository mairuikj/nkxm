package com.nkp.pojo;

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
    private Integer userphone;

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
    public Integer getUserphone() {
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
    public void setUserphone(Integer userphone) {
        this.userphone = userphone;
    }
}