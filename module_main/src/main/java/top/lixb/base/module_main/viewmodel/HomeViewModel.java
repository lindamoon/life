package top.lixb.base.module_main.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.view.View;

import com.vondear.rxtools.RxLogTool;

import java.io.IOException;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import top.lixb.base.module_main.activity.ApiActivity;
import top.lixb.libcommon.base.BaseViewModel;
import top.lixb.libcommon.config.CommonConfig;
import top.lixb.libcommon.net.CommonCallback;
import top.lixb.libcommon.net.NetApi;
import top.lixb.libcommon.net.ParamsBuilder;
import top.lixb.libcommon.net.NetApiHelper;

public class HomeViewModel extends BaseViewModel {

    public ObservableField<String> txt = new ObservableField<>();
    public ObservableArrayList<String> tabs = new ObservableArrayList<>();
    public HomeViewModel(Context context) {
        super(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        tabs.add("新闻头条");
        tabs.add("笑话大全");
        tabs.add("驾考题库查询");
    }

    public void clickToApi(View view) {
        startActivity(ApiActivity.class);
    }

}
