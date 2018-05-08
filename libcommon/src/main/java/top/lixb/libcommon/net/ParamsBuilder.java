package top.lixb.libcommon.net;

import android.text.TextUtils;

import com.vondear.rxtools.RxLogTool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ParamsBuilder {

    protected HashMap<String, String> mParams;
    public ParamsBuilder() {
        mParams = new HashMap<>();
    }

    public ParamsBuilder addP(String k, String v) {
        mParams.put(k, v);
        return this;
    }

    /**
     * 打印参数
     */
    protected void printParams(Map<String, String> params) {
        RxLogTool.w("===============params===============");
        Set<Map.Entry<String, String>> entries = params.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String value = entry.getValue();
            if (TextUtils.isEmpty(value)) {
                value = "参数为空";
            }
            RxLogTool.w(entry.getKey() + " : " + value);
        }
        RxLogTool.w("===============params===============");
    }

    public Map build() {
        return mParams;
    }

}
