package top.lixb.libcommon.refresh;

import android.content.ClipData;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.LayoutManagers;
import top.lixb.libcommon.R;
import top.lixb.libcommon.base.BaseApplication;
import top.lixb.libcommon.binding.BindingViewModel;

public class RefreshModel extends BindingViewModel {
    public ObservableBoolean loadmoreEnable = new ObservableBoolean(true);
    public ObservableBoolean refreshEnable = new ObservableBoolean(true);
}
