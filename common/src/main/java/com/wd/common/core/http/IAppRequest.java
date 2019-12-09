package com.wd.common.core.http;

import com.wd.common.bean.Banner;
import com.wd.common.bean.CircleBean;
import com.wd.common.bean.DepartmentBean;
import com.wd.common.bean.DetailsBean;
import com.wd.common.bean.PatientBean;
import com.wd.common.bean.Result;
import com.wd.common.bean.SickBean;
import com.wd.common.bean.UserInfoBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
}
