package top.lixb.base.module_main.fragment;


import android.os.Bundle;
import android.text.Html;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.FragmentPicjokeBinding;
import top.lixb.base.module_main.databinding.FragmentTextjokeBinding;
import top.lixb.base.module_main.viewmodel.PicJokeViewModel;
import top.lixb.base.module_main.viewmodel.TextJokeViewModel;
import top.lixb.libcommon.base.BaseFragment;

public class TextJokeFragment extends BaseFragment<FragmentTextjokeBinding,TextJokeViewModel> {

    public static TextJokeFragment newInstance() {
        Bundle args = new Bundle();
        TextJokeFragment fragment = new TextJokeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int initLayout() {
        return R.layout.fragment_textjoke;
    }

    @Override
    protected void initBinding(FragmentTextjokeBinding bind) {
        bind.setTextjoke(mViewModel);
    }
}
