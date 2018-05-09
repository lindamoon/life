package top.lixb.base.module_main.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.FragmentJokeBinding;
import top.lixb.base.module_main.databinding.FragmentPicjokeBinding;
import top.lixb.base.module_main.viewmodel.PicJokeViewModel;
import top.lixb.libcommon.base.BaseFragment;

public class PicJokeFragment extends BaseFragment<FragmentPicjokeBinding,PicJokeViewModel>  {
    public static PicJokeFragment newInstance() {
        Bundle args = new Bundle();
        PicJokeFragment fragment = new PicJokeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int initLayout() {
        return R.layout.fragment_picjoke;
    }

    @Override
    protected void initBinding(FragmentPicjokeBinding bind) {
        bind.setPicjoke(mViewModel);
    }


}
