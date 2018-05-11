package top.lixb.libcommon.binding;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;

import top.lixb.libcommon.base.BaseFragment;

public abstract class AbsBindingFragment<V extends ViewDataBinding, VM extends BindingViewModel> extends BaseFragment {

    protected V mBind;
    protected VM mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(getVMClass());
        mViewModel.onCreate();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBind = DataBindingUtil.inflate(inflater, initLayout(),container, false);
        initBinding(mBind);
        return mBind.getRoot();
    }


    protected Class<VM> getVMClass() {
        Class<VM> tClass = (Class<VM>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return tClass;
    }

    protected abstract int initLayout();

    protected abstract void initBinding(V bind);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewModel.onDestroy();
    }


}
