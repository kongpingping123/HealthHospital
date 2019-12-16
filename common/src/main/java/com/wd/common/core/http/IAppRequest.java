package com.wd.common.core.http;

import com.wd.common.bean.Collection;

import com.wd.common.bean.InFo;
import com.wd.common.bean.InteBase;
import com.wd.common.bean.LVienna;
import com.wd.common.bean.Login;
import com.wd.common.bean.Money;
import com.wd.common.bean.Popular;
import com.wd.common.bean.Querydoctor;
import com.wd.common.bean.Register;
import com.wd.common.bean.Result;
import com.wd.common.bean.Seach;
import com.wd.common.bean.Video;
import com.wd.common.bean.VideoComment;
import com.wd.common.bean.VideoGroup;
import com.wd.common.bean.VideoVo;
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

import com.wd.common.bean.Banner;
import com.wd.common.bean.BingBase;
import com.wd.common.bean.CommBase;
import com.wd.common.bean.DiseBase;
import com.wd.common.bean.DoctorBean;
import com.wd.common.bean.DonBase;
import com.wd.common.bean.DrugBase;
import com.wd.common.bean.DtonBase;
import com.wd.common.bean.IntBase;
import com.wd.common.bean.CircleBean;
import com.wd.common.bean.DepartmentBean;
import com.wd.common.bean.DetailsBean;
import com.wd.common.bean.PatientBean;
import com.wd.common.bean.Result;
import com.wd.common.bean.SearchBean;
import com.wd.common.bean.SousuoBase;
import com.wd.common.bean.XiangqingBase;
import com.wd.common.bean.YaoBase;
import com.wd.common.bean.ZixunBean;
import com.wd.common.bean.SickBean;
import com.wd.common.bean.UserInfoBean;

/**
 * @author dingtao
 * @date 2018/12/28 10:00
 * qq:1940870847
 */
public interface IAppRequest {

      @GET("share/v1/bannersShow")
    Observable<Result<List<Banner>>>bannershow();
    //病友圈列表数据
    @GET("user/sickCircle/v1/findSickCircleList")
    Observable<Result<List<CircleBean>>> findSickCircleList(@Query("departmentId") int departmentId,
                                                            @Query("page") int page,
                                                            @Query("count") int count);
    //查询科室列表
    @GET("share/knowledgeBase/v1/findDepartment")
    Observable<Result<List<DepartmentBean>>>findDepartment();
    //查询病友圈详情
    @GET("user/sickCircle/v1/findSickCircleInfo")
    Observable<Result<DetailsBean>> findSickCircleInfo(@Query("sickCircleId") int sickCircleId);
    //根据用户ID查询用户信息
    @GET("user/verify/v1/getUserInfoById")
    Observable<Result<UserInfoBean>> getUserInfoById();
    //查询病友圈评论列表
    @GET("user/sickCircle/v1/findSickCircleCommentList")
    Observable<Result<List<SickBean>>> findSickCircleCommentList(@Query("sickCircleId") int sickCircleId,
                                                                 @Query("page") int page,
                                                                 @Query("count") int count);
    //查看病友的病友圈发帖列表
    @GET("user/sickCircle/v1/findPatientSickCircleList")
    Observable<Result<List<PatientBean>>> findPatientSickCircleList(@Query("patientUserId") int patientUserId,
                                                                    @Query("page") int page,
                                                                    @Query("count") int count);
    //病友圈发表评论
    @POST("user/sickCircle/verify/v1/publishComment")
    Observable<Result> publishComment(@Header("userId") String uerId,
                                      @Header("sessionId")String sessionId,
                                      @Query("sickCircleId") int sickCircleId,
                                      @Query("content")String content);

       @GET("share/information/v1/findInformationPlateList")
       Observable<Result<List<ZixunBean>>>findInformationPlateList();

       @GET("share/information/v1/findInformationList")
      Observable<Result<List<XiangqingBase>>>xiangqingzixun(@Query("plateId")int plateId,@Query("page")int page,@Query("count")int count);

       @GET("share/knowledgeBase/v1/findDepartment")
      Observable<Result<List<DiseBase>>>bingzheng();
         @GET("share/knowledgeBase/v1/findDiseaseCategory")
       Observable<Result<List<BingBase>>>bingdiseaseCategory(@Query("departmentId")int departmentId);

            @GET("share/knowledgeBase/v1/findDrugsCategoryList")
        Observable<Result<List<DrugBase>>>drugbcategorylist();

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

            @GET("share/knowledgeBase/v1/findDrugsKnowledgeList")
         Observable<Result<List<YaoBase>>>yaofinddrugsknglist(@Query("drugsCategoryId")int drugsCategoryId,@Query("page")int page,@Query("count")int count);

            @GET("share/knowledgeBase/v1/findDiseaseKnowledge")
          Observable<Result<CommBase>> commdikndgehjr(@Query("id") int id);

             @GET("share/knowledgeBase/v1/findDrugsKnowledge")
          Observable<Result<DonBase>>donfindduknedge(@Query("id") int id);
             @GET("share/knowledgeBase/v1/findDrugsKnowledge")
           Observable<Result<IntBase>>intduiokonggen(@Query("id")int id);

             @GET("share/information/v1/findInformation")
           Observable<Result<DtonBase>>deisebase(@Query("infoId")int infoId);








             @GET("share/v1/homePageSearch")
            Observable<Result<SousuoBase>>ousuohomepage(@Query("keyWord") int keyWord);
    //根据关键词查询病友圈
    @GET("user/sickCircle/v1/searchSickCircle")
    Observable<Result<List<SearchBean>>>searchSickCircle(@Query("keyWord")String keyWord);
    //查询问诊医生列表
    @GET("user/inquiry/v1/findDoctorList")
    Observable<Result<List<DoctorBean>>>findDoctorList(@Query("deptId")int deptId,
                                                       @Query("condition")int condition,
                                                       @Query("sortBy")int sortBy,
                                                       @Query("page")int page,
                                                       @Query("count")int count);

      //查询我的被采纳的建议
     Observable<Result<List<InteBase>>> intecaifanyijian(@Query("page")int page,@Query("count")int count);



    //查询健康讲堂类目
    @GET("user/video/v1/findVideoCategoryList")
    Observable<Result<List<VideoGroup>>> findVideoCategoryList();


    //根据视频类目查询视频列表
    @GET("user/video/v1/findVideoVoList")
    Observable<Result<List<VideoVo>>> findVideoVoList(@Header("userId") int userId,
                                                      @Header("sessionId") String sessionId,
                                                      @Query("categoryId") int categoryId,
                                                      @Query("page") int page,
                                                      @Query("count") int count
    );


    //健康课堂视频购买
    @POST("user/video/verify/v1/videoBuy")
    @FormUrlEncoded
    Observable<Result> videoBuy(@Header("userId") int userId,
                                @Header("sessionId") String sessionId,
                                @Field("videoId") int videoId,
                                @Field("price") int price
    );

    //发表视频评论（弹幕）
    @POST("user/video/verify/v1/addVideoComment")
    @FormUrlEncoded
    Observable<Result> addVideoComment(@Header("userId") int userId,
                                       @Header("sessionId") String sessionId,
                                       @Field("videoId") int videoId,
                                       @Field("price") String price
    );

    //查询视频评论列表
    @GET("user/video/v1/findVideoCommentList")
    Observable<Result<List<VideoComment>>> findVideoCommentList(@Query("videoId") int videoId);


    //健康课堂视频收藏
    @POST("user/video/verify/v1/addUserVideoCollection")
    @FormUrlEncoded
    Observable<Result> addUserVideoCollection(@Header("userId") int userId,
                                              @Header("sessionId") String sessionId,
                                              @Field("videoId") int videoId);



   //查询用户收藏病友圈列表
    @GET("user/verify/v1/findUserSickCollectionList")
    Observable<Result<List<Collection>>>findUserSickCollectionList(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);

    //查询医生明细信息



    //热门搜索
    @GET("share/v1/popularSearch")
    Observable<Result<List<Popular>>>popularSearch();

    //查询用户关注医生列表
    @GET("user/verify/v1/findUserDoctorFollowList")
    Observable<Result<List<Querydoctor>>>findUserDoctorFollowList(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);

    //首页搜索
    @GET("share/v1/homePageSearch")
    Observable<Result<Seach>>homePageSearch(@Query("keyWord")String keyWord);

}




