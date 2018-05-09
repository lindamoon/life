package top.lixb.base.module_main.fragment;


import android.os.Bundle;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.FragmentGifjokeBinding;
import top.lixb.base.module_main.databinding.FragmentTextjokeBinding;
import top.lixb.base.module_main.viewmodel.GifJokeViewModel;
import top.lixb.base.module_main.viewmodel.TextJokeViewModel;
import top.lixb.libcommon.base.BaseFragment;

public class GifJokeFragment extends BaseFragment<FragmentGifjokeBinding,GifJokeViewModel> {

    public static GifJokeFragment newInstance() {
        Bundle args = new Bundle();
        GifJokeFragment fragment = new GifJokeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int initLayout() {
        return R.layout.fragment_gifjoke;
    }

    @Override
    protected void initBinding(FragmentGifjokeBinding bind) {
        bind.setGifjoke(mViewModel);
        
    }
}
