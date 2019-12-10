package com.wd.common.core.http;

import com.wd.common.bean.InFo;
import com.wd.common.bean.LVienna;
import com.wd.common.bean.Login;
import com.wd.common.bean.Money;
import com.wd.common.bean.Register;
import com.wd.common.bean.Result;
import com.wd.common.bean.Video;
import com.wd.common.bean.Vienna;
import com.wd.common.bean.WeiXin;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * @author dingtao
 * @date 2018/12/28 10:00
 * qq:1940870847
 */
public interface IAppRequest {


    //登录
    @FormUrlEncoded
    @POST("user/v1/login")
    Observable<Result<Login>>login(@Field("email") String email, @Field("pwd") String pwd);

    //发送邮箱验证码
    @FormUrlEncoded
    @POST("user/v1/sendOutEmailCode")
    Observable<Result>sendOutEmailCode(@Field("email")String email);

    //注册
    @FormUrlEncoded
    @POST("user/v1/register")
    Observable<Result<Register>>register(@Field("email") String email, @Field("code") String code,@Field("pwd1") String pwd1,@Field("pwd2") String pwd2);

    //修改密码
    @FormUrlEncoded
    @PUT("user/verify/v1/updateUserPwd")
    Observable<Result>updateUserPwd(@Header("userId") String userId, @Header("sessionId") String sessionId, @Field("oldPwd")String oldPwd, @Field("newPwd")String newPwd);


    //签到
    @POST("user/verify/v1/addSign")
    Observable<Result>addSign(@Header("userId") int userId,@Header("sessionId") String sessionId);

    //微信登录
    @POST("user/v1/weChatLogin")
    Observable<Result<WeiXin>>weChatLogin(@Query("wxCode")String wxCode);

    //当前问诊
    @GET("user/inquiry/verify/v1/findCurrentInquiryRecord")
    Observable<Result<Vienna>>findCurrentInquiryRecord(@Header("userId")int userId,@Header("sessionId")String sessionId);

    //历史问诊
    @GET("user/inquiry/verify/v1/findHistoryInquiryRecord")
    Observable<Result<List<LVienna>>>findHistoryInquiryRecord(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);

    //我的钱包
    @GET("user/verify/v1/findUserWallet")
    Observable<Result>findUserWallet(@Header("userId")int userId, @Header("sessionId")String sessionId);

    //用户消费记录
    @GET("user/verify/v1/findUserConsumptionRecordList")
    Observable<Result<List<Money>>>findUserConsumptionRecordList(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);

    //查询用户资讯收藏列表
    @GET("user/verify/v1/findUserInfoCollectionList")
    Observable<Result<List<InFo>>>findUserInfoCollectionList(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);

    //查询用户视频收藏
    @GET("user/verify/v1/findVideoCollectionList")
    Observable<Result<List<Video>>>findVideoCollectionList(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);

    //查询用户收藏病友圈列表

}
