package top.lixb.base.module_main.fragment;


import android.os.Bundle;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.FragmentDriverexamBinding;
import top.lixb.base.module_main.viewmodel.DriverexamViewModel;
import top.lixb.libcommon.binding.AbsBindingFragment;

public class DriverexamFragment extends AbsBindingFragment<FragmentDriverexamBinding,DriverexamViewModel> {
    public static DriverexamFragment newInstance() {
        Bundle args = new Bundle();
        DriverexamFragment fragment = new DriverexamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_driverexam;
    }

    @Override
    protected void initBinding(FragmentDriverexamBinding bind) {
        bind.setDriverexam(mViewModel);
    }
}
