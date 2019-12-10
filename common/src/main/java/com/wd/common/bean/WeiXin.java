package com.wd.common.bean;

public class WeiXin {
    //id	int	用户ID
    //sessionId	string	用户登陆凭证
    //nickName	string	用户昵称
    //userName	string	极光IM的账号
    //jiGuangPwd	String	极光密码，客户端需要先用公钥对其解密，然后用MD5加密后再使用
    //headPic	string	用户头像地址
    //sex	int	性别
    //age	int	年龄
    //height	int	身高/cm
    //weight	int	体重/kg
    //email	string	邮箱，如果为空则需要跳转到完善邮箱页
    //whetherBingWeChat	int	是否绑定微信 1=是，2=否
    public int id;
    public String sessionId;
    public String nickName;
    public String userName;
    public String jiGuangPwd;
    public String headPic;
    public String email;
    public int sex;
    public int age;
    public int height;
    public int weight;
    public int whetherBingWeChat;
}
