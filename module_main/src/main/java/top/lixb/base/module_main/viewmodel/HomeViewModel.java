package top.lixb.base.module_main.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import top.lixb.libcommon.binding.BindingViewModel;
import top.lixb.libsrc.router.RouteTable;

public class HomeViewModel extends BindingViewModel {

    public ObservableField<String> txt = new ObservableField<>();
    public ObservableArrayList<String> tabs = new ObservableArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        tabs.add("新闻头条");
        tabs.add("笑话大全");
        tabs.add("驾考题库查询");
    }

    public void clickToApi(View view) {
        ARouter.getInstance().build(RouteTable.mainApi).navigation();
    }
}
