package top.lixb.base.module_main.fragment;


import android.os.Bundle;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.MainFragmentHomeBinding;
import top.lixb.base.module_main.viewmodel.HomeViewModel;
import top.lixb.libcommon.binding.AbsBindingFragment;

public class HomeFragment extends AbsBindingFragment<MainFragmentHomeBinding,HomeViewModel> {

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
