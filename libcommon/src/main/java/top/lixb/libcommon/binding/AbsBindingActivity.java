package top.lixb.libcommon.binding;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.lang.reflect.ParameterizedType;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import top.lixb.libcommon.R;
import top.lixb.libcommon.base.BaseActivity;

public abstract class AbsBindingActivity<V extends ViewDataBinding,VM extends BindingViewModel> extends BaseActivity {

    protected V mBinding;
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(getVMClass());
        mViewModel.onCreate();
    }

    protected Class<VM> getVMClass() {
        Class<VM> tClass = (Class<VM>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return tClass;
    }


    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        mBinding = DataBindingUtil.bind(view);
        initBinding(mBinding);
        mBinding.executePendingBindings();
    }

    protected abstract void initBinding(V binding);



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.onDestroy();
    }
}
