package top.lixb.base.module_main.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.vondear.rxtools.RxLogTool;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import top.lixb.base.module_main.R;
import top.lixb.base.module_main.BR;
import top.lixb.libcommon.binding.BindingViewModel;
import top.lixb.libcommon.config.CommonConfig;
import top.lixb.libcommon.net.CommonCallback;
import top.lixb.libcommon.net.ParamsBuilder;
import top.lixb.libsrc.bean.PicJokeBean;

public class PicJokeViewModel extends BindingViewModel {

    private Gson mGson;
    private String maxResult = CommonConfig.pageSize;
    private String page="1";
    private String time;

    public final BindingRecyclerViewAdapter<PicJokeBean.ShowapiResBodyBean.ContentlistBean> adapter = new BindingRecyclerViewAdapter<>();
    public final ObservableArrayList<PicJokeBean.ShowapiResBodyBean.ContentlistBean> items = new ObservableArrayList<>();
    public final ItemBinding<PicJokeBean.ShowapiResBodyBean.ContentlistBean> singleItem = ItemBinding.of(BR.item, R.layout.main_item_api_picjoke);
    public final BindingRecyclerViewAdapter.ViewHolderFactory viewHolder = new BindingRecyclerViewAdapter.ViewHolderFactory() {
        @Override
        public RecyclerView.ViewHolder createViewHolder(ViewDataBinding binding) {
            return new MyAwesomeViewHolder(binding.getRoot());
        }
    };
    private RefreshLayout mRefreshLayout;


    public static class MyAwesomeViewHolder extends RecyclerView.ViewHolder {
        public MyAwesomeViewHolder(View itemView) {
            super(itemView);
        }
    }

    public OnLoadMoreListener loadmoreListener = new OnLoadMoreListener() {
        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            page = String.valueOf(Integer.valueOf(page) + 1);
            mRefreshLayout = refreshLayout;
            requestData();
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        mGson = new Gson();
        requestData();
    }

    private void requestData() {
        performGetRequest(CommonConfig.url_joke,"picJoke", new ParamsBuilder()
                .addP("maxResult",maxResult)
                .addP("page",page)
                .addP("time","2017-01-01")
                .build(), new CommonCallback() {
            @Override
            public void onResponse(String response) {
                PicJokeBean picJokeBean = mGson.fromJson(response, PicJokeBean.class);
                items.addAll(picJokeBean.showapi_res_body.contentlist);
                if (null != mRefreshLayout) {
                    if (picJokeBean.showapi_res_body.contentlist.size() == 0) {
                        mRefreshLayout.setNoMoreData(true);
                    }
                    mRefreshLayout.finishLoadMore(2000);
                }

            }

            @Override
            public void onError(Throwable e) {
                RxLogTool.e("onError"+e.getMessage());
                if (null != mRefreshLayout) {
                    mRefreshLayout.finishLoadMore(false);
                }
            }
        });
    }
}
