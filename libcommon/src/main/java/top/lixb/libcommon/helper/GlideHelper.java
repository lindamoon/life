package top.lixb.libcommon.helper;

import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import top.lixb.libcommon.glide.GlideApp;

public class GlideHelper {
    public static void loadGif(ImageView iv, String url) {
        GlideApp.with(iv).asGif().load(url).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(iv);
    }

    public static void loadImg(ImageView iv, String url) {
        GlideApp.with(iv).load(url).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(iv);
    }
}
