package top.lixb.libcommon.base;

import android.app.Activity;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;

import com.vondear.rxtools.RxNetTool;
import com.vondear.rxtools.view.RxToast;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import top.lixb.libcommon.net.CommonCallback;
import top.lixb.libcommon.net.INet;
import top.lixb.libcommon.net.NetApiHelper;

public class BaseViewModel extends ViewModel implements IBaseViewModel,INet {
    protected Context mContext;

    public BaseViewModel(Context context) {
        mContext = context;
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }


    private void showProgressDialog() {
        RxToast.showToast("showProgressDialog");
    }


    @Override
    public void performGetRequest(String url, Map<String, String> params, CommonCallback callback) {
        NetApiHelper.createNetApi()
                .commonGetRequest(url, params, NetApiHelper.getCommonHeader())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback)
        ;
    }

    @Override
    public void performPostRequest(String url, Map<String, String> params, CommonCallback callback) {
        NetApiHelper.createNetApi()
                .commonPostRequest(url, params, NetApiHelper.getCommonHeader())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback)
        ;
    }

    protected <T extends Activity> void startActivity(Class<T> classzz) {
        mContext.startActivity(new Intent(mContext,classzz));
    }
}
