package top.lixb.libcommon.net;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import top.lixb.libcommon.config.CommonConfig;

public class NetApiHelper {
    private static Map<String, NetApi> apiMap = new TreeMap<>();
    private static OkHttpClient mClient;

    static {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        mClient = builder.build();
    }

    public static NetApi createNetApi(String baseUrl) {
        NetApi netApi = apiMap.get(baseUrl);
        if (null != netApi) {
            return netApi;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mClient)
                .build();
        netApi = retrofit.create(NetApi.class);
        apiMap.put(baseUrl, netApi);
        return netApi;
    }

    public static NetApi createJokeApi() {
        return createNetApi(CommonConfig.url_joke);
    }

    public static Map<String, String> getCommonHeader() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "APPCODE " + CommonConfig.appcode);
        return header;
    }

}
