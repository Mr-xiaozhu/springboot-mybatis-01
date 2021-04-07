package com.mrxiaozhu.springbootmybatis01.pojo;

import javax.validation.constraints.NotBlank;

/**
 *  Email 实体类
 *  服务端表单数据校验的校验规则：
 *  @NotBlank: 判断字符串是否为 null 或者是空串(去掉首尾空格)。
 *  @NotEmpty: 判断字符串是否 null 或者是空串。
 *  @Length: 判断字符的长度(最大或者最小)
 *  @Min: 判断数值最小值
 *  @Max: 判断数值最大值
 *  @Email: 判断邮箱是否合法
 */
public class Email {
    private int id;
    @NotBlank
    private String sUser;
    @NotBlank
    private String fTime;
    @NotBlank
    private String fUser;
    @NotBlank
    private String fPwd;
    @NotBlank
    private String emailTitle;
    private String emailContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsUser() {
        return sUser;
    }

    public void setsUser(String sUser) {
        this.sUser = sUser;
    }

    public String getfTime() {
        return fTime;
    }

    public void setfTime(String fTime) {
        this.fTime = fTime;
    }

    public String getfUser() {
        return fUser;
    }

    public void setfUser(String fUser) {
        this.fUser = fUser;
    }

    public String getfPwd() {
        return fPwd;
    }

    public void setfPwd(String fPwd) {
        this.fPwd = fPwd;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", sUser='" + sUser + '\'' +
                ", fTime='" + fTime + '\'' +
                ", fUser='" + fUser + '\'' +
                ", fPwd='" + fPwd + '\'' +
                ", emailTitle='" + emailTitle + '\'' +
                ", emailContent='" + emailContent + '\'' +
                '}';
    }
}
