package top.lixb.life;

import cn.jpush.android.api.JPushInterface;
import top.lixb.libcommon.base.BaseApplication;

public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(BuildConfig.DEBUG);
        JPushInterface.init(this);
    }
}
