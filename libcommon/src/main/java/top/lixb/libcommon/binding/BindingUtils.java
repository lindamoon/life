package top.lixb.libcommon.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.vondear.rxtools.RxLogTool;

import top.lixb.libcommon.base.BaseBindingRecyclerViewAdapter;
import top.lixb.libcommon.glide.GlideApp;
import top.lixb.libcommon.helper.GlideHelper;

public class BindingUtils {

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

    @BindingAdapter("adapter")
    public static void setLayoutManager(RecyclerView rv, BaseBindingRecyclerViewAdapter adapter) {
        if (adapter != rv.getAdapter()) {
            rv.setAdapter(adapter);
        }
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView iv, String url) {
        if (!TextUtils.isEmpty(url)&&url.toLowerCase().endsWith(".gif")) {
            GlideApp.with(iv).asGif().load(url).into(iv);
        } else {
            GlideApp.with(iv).load(url).into(iv);
        }
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
}
