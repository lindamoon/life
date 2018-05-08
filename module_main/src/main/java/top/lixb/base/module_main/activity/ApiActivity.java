package top.lixb.base.module_main.activity;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.ActivityApiBinding;
import top.lixb.base.module_main.viewmodel.ApiViewModel;
import top.lixb.libcommon.base.BaseActivity;

public class ApiActivity extends BaseActivity<ActivityApiBinding,ApiViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

    }

    @Override
    protected void initBinding(ActivityApiBinding binding) {
        binding.setApi(mViewModel);

    }
}
