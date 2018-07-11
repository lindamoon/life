package top.lixb.base.module_main.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import top.lixb.libcommon.binding.BindingViewModel;
import top.lixb.libsrc.router.RouteTable;

public class HomeViewModel extends BindingViewModel {

    public ObservableField<String> txt = new ObservableField<>();
    public ObservableArrayList<String> tabs = new ObservableArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        tabs.add("新闻头条");
        tabs.add("笑话大全");
        tabs.add("驾考题库查询");
    }

    public void clickToApi(View view) {
        ARouter.getInstance().build(RouteTable.mainApi).navigation();
    }
    public static final String URL = "http://119.23.226.159/operatelog/list";
    public void clickToStocklog(View view) {
        ARouter.getInstance().build(RouteTable.mainWeb).withString("url",URL).navigation();
    }

    public OnLoadMoreListener loadmoreListener = new OnLoadMoreListener() {
        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            refreshLayout.finishLoadMore(2000);
        }
    };

    public OnRefreshListener refreshListener = new OnRefreshListener() {
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            refreshLayout.finishRefresh(2000);
        }
    };

}
