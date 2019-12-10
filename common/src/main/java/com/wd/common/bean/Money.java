package com.wd.common.bean;

public class Money {

    //direction	int	消费 1为收入，2为支出
    //type	int	消费具体方式：1=签到，2=病友圈首评，3=首发病友圈，4=完善档案，5=健康评测 6=悬赏消费 7=悬赏奖励 8=邀请奖励 9=问诊消费 10=问诊收入，11=观看资讯 12=送礼物 13=绑定身份证 14=绑定银行卡 15=充值 16=提现，17 = 购买健康视频
    //changeNum	int	明细，收入支出具体金额
    //remark	string	备注
    //createTime	long	消费时间

    public int direction;
    public int type;
    public int changeNum;
    public String remark;
    public long createTime;
}
