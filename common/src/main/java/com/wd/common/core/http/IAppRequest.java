package com.wd.common.core.http;

import com.wd.common.bean.Banner;
import com.wd.common.bean.BingBase;
import com.wd.common.bean.CommBase;
import com.wd.common.bean.DiseBase;
import com.wd.common.bean.DoctorBean;
import com.wd.common.bean.DonBase;
import com.wd.common.bean.DrugBase;
import com.wd.common.bean.IntBase;
import com.wd.common.bean.CircleBean;
import com.wd.common.bean.DepartmentBean;
import com.wd.common.bean.DetailsBean;
import com.wd.common.bean.PatientBean;
import com.wd.common.bean.Result;
import com.wd.common.bean.SearchBean;
import com.wd.common.bean.XiangqingBase;
import com.wd.common.bean.YaoBase;
import com.wd.common.bean.ZixunBean;
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

            @GET("share/knowledgeBase/v1/findDrugsKnowledgeList")
         Observable<Result<List<YaoBase>>>yaofinddrugsknglist(@Query("drugsCategoryId")int drugsCategoryId,@Query("page")int page,@Query("count")int count);

            @GET("share/knowledgeBase/v1/findDiseaseKnowledge")
          Observable<Result<CommBase>> commdikndgehjr(@Query("id") int id);

             @GET("share/knowledgeBase/v1/findDrugsKnowledge")
          Observable<Result<DonBase>>donfindduknedge(@Query("id") int id);
             @GET("share/knowledgeBase/v1/findDrugsKnowledge")
           Observable<Result<IntBase>>intduiokonggen(@Query("id")int id);
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
}




