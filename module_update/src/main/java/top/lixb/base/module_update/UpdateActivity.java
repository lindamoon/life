package top.lixb.base.module_update;

import android.support.annotation.Nullable;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import top.lixb.base.module_update.databinding.ActivityUpdateBinding;
import top.lixb.base.module_update.viewmodel.UpdateViewModel;
import top.lixb.libcommon.base.BaseActivity;
import top.lixb.libsrc.router.RouteTable;

@Route(path = RouteTable.updateIndex)
public class UpdateActivity extends BaseActivity<ActivityUpdateBinding,UpdateViewModel> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }


    @Override
    protected void initBinding(ActivityUpdateBinding binding) {
        binding.setViewModel(mViewModel);
    }
}
