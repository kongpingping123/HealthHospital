package com.wd.common.bean;

public class Login {

//
//    id	int	用户ID
//    sessionId	string	用户登陆凭证
//    nickName	string	用户昵称
//    userName	string	极光IM的账号
//    jiGuangPwd	String	极光密码，客户端需要先用公钥对其解密，然后用MD5加密后再使用，MD5加密方法参考维度电影中的处理方式MD5处理
//    headPic	string	用户头像地址
//    sex	int	性别
//    age	int	年龄
//    height	int	身高/cm
//    weight	int	体重/kg
//    email	string	注册邮箱
//    whetherBingWeChat	int	是否绑定微信 1=是，2=否
//    invitationCode	RTTNASJBQI	邀请码

    public String sessionId;
    public String nickName;
    public String userName;
    public String headPic;
    public String email;
    public int  id;
    public int  sex;
    public int  age;
    public int  height;
    public int  weight;
    //public RTTNASJBQI  invitationCode;
}
