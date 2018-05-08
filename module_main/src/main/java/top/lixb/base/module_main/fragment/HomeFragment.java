package top.lixb.base.module_main.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.MainFragmentHomeBinding;
import top.lixb.base.module_main.viewmodel.HomeViewModel;
import top.lixb.libcommon.base.BaseFragment;

public class HomeFragment extends BaseFragment<MainFragmentHomeBinding,HomeViewModel> {

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int initLayout() {
        return R.layout.main_fragment_home;
    }

    @Override
    protected void initBinding(MainFragmentHomeBinding bind) {
        bind.setHome(mViewModel);
    }

}
