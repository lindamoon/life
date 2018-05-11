package top.lixb.base.module_main.viewmodel;

import top.lixb.libcommon.binding.BindingViewModel;

public class ItemViewModel extends BindingViewModel {

    private String mTitle;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
