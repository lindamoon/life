package top.lixb.libcommon.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.request.RequestOptions;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.List;

import top.lixb.libcommon.base.BaseBindingRecyclerViewAdapter;
import top.lixb.libcommon.base.IBindingItem;

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
        Glide.with(iv).setDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .load(url).into(iv);
    }



    @BindingAdapter("htmlText")
    public static void setHtmlText(TextView tv, String htmlTxt) {

        //去除太多的空行
        String replace = htmlTxt.replace("<br>", "").replace("<br />", "");
        tv.setText(replace);
    }

    @BindingAdapter("onloadmoreListener")
    public static void setLoadmoreListener(SmartRefreshLayout layout, OnLoadMoreListener loadMoreListener) {
        layout.setOnLoadMoreListener(loadMoreListener);
    }
}
