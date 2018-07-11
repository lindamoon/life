package top.lixb.libcommon.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import top.lixb.libcommon.glide.GlideApp;
import top.lixb.libcommon.refresh.RVViewHolder;

/**
 * 自定义添加的binding adapter
 */
public class BindingAdapters {

    @BindingAdapter("image")
    public static void loadImage(ImageView iv, int resId) {
        iv.setImageResource(resId);
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView rv, RecyclerView.LayoutManager manager) {
        if (manager != rv.getLayoutManager()) {
            rv.setLayoutManager(manager);
        }
    }


    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView iv, String url) {

        GlideApp.with(iv).load(url).into(iv);

    }


    @BindingAdapter("htmlText")
    public static void setHtmlText(TextView tv, String htmlTxt) {
        if (!TextUtils.isEmpty(htmlTxt)) {
            //去除太多的空行
            String replace = htmlTxt.replace("<br>", "").replace("<br />", "");
            tv.setText(replace);
        }
    }

    @BindingAdapter("onloadmoreListener")
    public static void setLoadmoreListener(SmartRefreshLayout layout, OnLoadMoreListener loadMoreListener) {
        layout.setOnLoadMoreListener(loadMoreListener);
    }

    @BindingAdapter("onrefreshListener")
    public static void setLoadmoreListener(SmartRefreshLayout layout, OnRefreshListener refreshListener) {
        layout.setOnRefreshListener(refreshListener);
    }

    @BindingAdapter("enableLoadmore")
    public static void setLoadmoreEnable(SmartRefreshLayout layout, boolean enable) {
        layout.setEnableLoadMore(enable);
    }
    @BindingAdapter("enableRefresh")
    public static void setRefreshEnable(SmartRefreshLayout layout, boolean enable) {
        layout.setEnableRefresh(enable);
    }

    @BindingAdapter("rvadapter")
    public static void setAdapter(RecyclerView rv,RecyclerView.Adapter<RVViewHolder> adapter){
        rv.setAdapter(adapter);
    }

    @BindingAdapter("rvlayout")
    public static void setLayoutManage(RecyclerView rv, RecyclerView.LayoutManager manager) {
        rv.setLayoutManager(manager);
    }

}
