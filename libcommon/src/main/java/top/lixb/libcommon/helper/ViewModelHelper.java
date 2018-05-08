package top.lixb.libcommon.helper;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

public class ViewModelHelper {
    private static ViewModelHelper instance;
    private static ViewModelProvider.AndroidViewModelFactory sProvider;

    public synchronized static ViewModelHelper getInstance(Application app) {
        if (null == instance) {
            synchronized (ViewModelHelper.class) {
                instance = new ViewModelHelper();
                sProvider = ViewModelProvider.AndroidViewModelFactory.getInstance(app);
            }
        }
        return instance;
    }

    public <T extends ViewModel> T create(Class<T> modelClass) {
        return sProvider.create(modelClass);
    }
}
