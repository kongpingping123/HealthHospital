package com.wd.common.core.http;

import com.wd.common.bean.Banner;
import com.wd.common.bean.BingBase;
import com.wd.common.bean.CommBase;
import com.wd.common.bean.DiseBase;
import com.wd.common.bean.DonBase;
import com.wd.common.bean.DrugBase;
import com.wd.common.bean.IntBase;
import com.wd.common.bean.Result;
import com.wd.common.bean.XiangqingBase;
import com.wd.common.bean.YaoBase;
import com.wd.common.bean.ZixunBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
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
}
