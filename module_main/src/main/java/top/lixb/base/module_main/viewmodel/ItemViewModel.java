package top.lixb.base.module_main.viewmodel;

import android.content.Context;

import top.lixb.libcommon.base.BaseViewModel;

public class ItemViewModel extends BaseViewModel {

    private String mTitle;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
