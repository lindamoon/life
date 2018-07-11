package top.lixb.base.module_main.fragment;


import android.os.Bundle;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.FragmentPicjokeBinding;
import top.lixb.base.module_main.viewmodel.PicJokeViewModel;
import top.lixb.libcommon.binding.AbsBindingFragment;

public class PicJokeFragment extends AbsBindingFragment<FragmentPicjokeBinding,PicJokeViewModel> {
    public static PicJokeFragment newInstance() {
        Bundle args = new Bundle();
        PicJokeFragment fragment = new PicJokeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_picjoke;
    }

    @Override
    protected void initBinding(FragmentPicjokeBinding bind) {
        bind.setPicjoke(mViewModel);
    }


}
