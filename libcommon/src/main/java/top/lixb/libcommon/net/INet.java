package top.lixb.libcommon.net;

import java.util.Map;

public interface INet {
    void performGetRequest(String baseUrl,String url,Map<String,String> params,CommonCallback callback);

    void performPostRequest(String baseUrl,String url,Map<String,String> params,CommonCallback callback);
}
