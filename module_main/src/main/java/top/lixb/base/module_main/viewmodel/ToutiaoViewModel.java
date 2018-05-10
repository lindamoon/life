package top.lixb.base.module_main.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.vondear.rxtools.RxLogTool;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import top.lixb.base.module_main.BR;
import top.lixb.base.module_main.R;
import top.lixb.libcommon.base.BaseViewModel;
import top.lixb.libcommon.config.CommonConfig;
import top.lixb.libcommon.net.CommonCallback;
import top.lixb.libcommon.net.ParamsBuilder;
import top.lixb.libsrc.bean.PicJokeBean;
import top.lixb.libsrc.bean.ToutiaoNewsBean;

public class ToutiaoViewModel extends BaseViewModel {


    public final BindingRecyclerViewAdapter<ToutiaoNewsBean.ResultBean.DataBean> adapter = new BindingRecyclerViewAdapter<>();
    public final ObservableArrayList<ToutiaoNewsBean.ResultBean.DataBean> items = new ObservableArrayList<>();
    public final ItemBinding<ToutiaoNewsBean.ResultBean.DataBean> singleItem = ItemBinding.of(BR.item, R.layout.main_item_api_toutiao);
    public final BindingRecyclerViewAdapter.ViewHolderFactory viewHolder = new BindingRecyclerViewAdapter.ViewHolderFactory() {
        @Override
        public RecyclerView.ViewHolder createViewHolder(ViewDataBinding binding) {
            return new MyAwesomeViewHolder(binding.getRoot());
        }
    };
    private RefreshLayout mRefreshLayout;


    public class MyAwesomeViewHolder extends RecyclerView.ViewHolder {
        public MyAwesomeViewHolder(View itemView) {
            super(itemView);
        }
    }

    public OnLoadMoreListener loadmoreListener = new OnLoadMoreListener() {
        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            mRefreshLayout = refreshLayout;
            requestData();
        }
    };

    public OnRefreshListener refreshListener = new OnRefreshListener() {
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            mRefreshLayout = refreshLayout;
            items.clear();
            requestData();
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        requestData();
    }

    private void requestData() {
        performGetRequest(CommonConfig.url_news, "toutiao/index", new ParamsBuilder().build(), new CommonCallback() {
            @Override
            public void onResponse(String response) {
                RxLogTool.e(response);
                ToutiaoNewsBean toutiaoNewsBean = new Gson().fromJson(response, ToutiaoNewsBean.class);
                items.addAll(toutiaoNewsBean.result.data);
                if (null != mRefreshLayout) {
                    mRefreshLayout.setNoMoreData(true);
                    mRefreshLayout.finishLoadMore(2000);
                    mRefreshLayout.finishRefresh(2000);
                }
            }

            @Override
            public void onError(Throwable e) {
                if (null != mRefreshLayout) {
                    mRefreshLayout.finishRefresh(false);
                    mRefreshLayout.finishLoadMore(false);
                }
            }
        });
    }
}
