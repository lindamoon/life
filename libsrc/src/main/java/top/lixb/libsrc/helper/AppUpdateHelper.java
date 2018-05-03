package top.lixb.libsrc.helper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import top.lixb.libsrc.bean.AppUpdateBean;

public class AppUpdateHelper {
    private static AppUpdateHelper instance;

    private AppUpdateHelper() {

    }

    public synchronized static AppUpdateHelper getInstance() {
        if (instance == null) {
            synchronized (AppUpdateHelper.class) {
                instance = new AppUpdateHelper();
            }
        }
        return instance;
    }

    public interface IUpdateCheckCallback{
        void onCheckUpdate(boolean hasNewVersion,@Nullable AppUpdateBean bean);
    }

    public void checkUpdate(@NonNull IUpdateCheckCallback callback) {
        // TODO: 2018-05-03 检查是否有新版本

    }
}
