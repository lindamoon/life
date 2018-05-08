package top.lixb.libcommon.net;


import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import top.lixb.libcommon.config.CommonConfig;

public class NetApiHelper {
    private static NetApi mNetApi;
    public static NetApi createNetApi() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        OkHttpClient client = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        mNetApi = retrofit.create(NetApi.class);
        return mNetApi;
    }

    public static Map<String, String> getCommonHeader() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "APPCODE " + CommonConfig.appcode);
        return header;
    }

}
