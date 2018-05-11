package top.lixb.libcommon.binding;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModel;
import android.widget.ProgressBar;

import com.vondear.rxtools.view.RxToast;
import com.vondear.rxtools.view.dialog.RxDialogLoading;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import top.lixb.libcommon.net.CommonCallback;
import top.lixb.libcommon.net.INet;
import top.lixb.libcommon.net.NetApiHelper;

public class BindingViewModel extends ViewModel implements IBindingViewModel,INet {

    public BindingViewModel() {

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
