package top.lixb.libcommon.net;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface NetApi {

    //*********************  *********************
    @POST(" ")
    @FormUrlEncoded()
    Observable<ResponseBody> commonPostRequest(@FieldMap Map<String, String> params);
    @POST
    @FormUrlEncoded()
    Observable<ResponseBody> commonPostRequest(@Url String url, @FieldMap Map<String, String> params);

    //*********************  *********************
    @GET
    Observable<ResponseBody> commonGetRequest(@Url String url, @QueryMap Map<String, String> params);
    @GET
    Observable<ResponseBody> commonGetRequest(@QueryMap Map<String, String> params);
    @GET
    Observable<ResponseBody> commonGetRequest(@Url String url);


}
