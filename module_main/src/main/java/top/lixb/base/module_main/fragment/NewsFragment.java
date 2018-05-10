package top.lixb.base.module_main.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.FragmentNewToutiaoBinding;
import top.lixb.base.module_main.viewmodel.ToutiaoViewModel;
import top.lixb.libcommon.base.BaseFragment;

public class NewsFragment extends BaseFragment<FragmentNewToutiaoBinding,ToutiaoViewModel> {
    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_new_toutiao;
    }

    @Override
    protected void initBinding(FragmentNewToutiaoBinding bind) {
        bind.setNews(mViewModel);
    }
}
