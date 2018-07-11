package top.lixb.libcommon.refresh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import top.lixb.libcommon.R;
import top.lixb.libcommon.base.BaseActivity;
import top.lixb.libcommon.binding.AbsBindingActivity;
import top.lixb.libcommon.databinding.ActivityBaseRefreshBinding;

public class RefreshActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_refresh);
    }

}
