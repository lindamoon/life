package top.lixb.libcommon.base;

import android.app.Activity;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;
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

    public BaseViewModel() {

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
    public void performGetRequest(String baseUrl,String url, Map<String, String> params, CommonCallback callback) {
        NetApiHelper.createNetApi(baseUrl)
                .commonGetRequest(url, params, NetApiHelper.getCommonHeader())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback)
        ;
    }

    @Override
    public void performPostRequest(String baseUrl,String url, Map<String, String> params, CommonCallback callback) {
        NetApiHelper.createNetApi(baseUrl)
                .commonPostRequest(url, params, NetApiHelper.getCommonHeader())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback)
        ;
    }

}
