package top.lixb.libcommon.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

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
        if (adapter!=rv.getAdapter()) {
            rv.setAdapter(adapter);
        }
    }


}
