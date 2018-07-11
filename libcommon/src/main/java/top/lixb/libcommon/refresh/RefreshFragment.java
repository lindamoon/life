package top.lixb.libcommon.refresh;

import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.lixb.libcommon.R;
import top.lixb.libcommon.base.BaseFragment;
import top.lixb.libcommon.binding.AbsBindingFragment;
import top.lixb.libcommon.databinding.ActivityBaseRefreshBinding;

public class  RefreshFragment extends BaseFragment {
    public static RefreshFragment newInstance() {
        Bundle args = new Bundle();
        RefreshFragment fragment = new RefreshFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initView(View view) {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_base_refresh;
    }
}
