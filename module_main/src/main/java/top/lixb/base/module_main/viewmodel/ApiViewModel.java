package top.lixb.base.module_main.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;

import top.lixb.libcommon.base.BaseViewModel;

public class ApiViewModel extends BaseViewModel {

    public final ObservableList<ItemViewModel> items = new ObservableArrayList<>();
    public ApiViewModel(Context context) {
        super(context);
    }


}
