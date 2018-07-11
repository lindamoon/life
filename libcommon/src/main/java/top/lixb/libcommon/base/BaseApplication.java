package top.lixb.libcommon.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.vondear.rxtools.RxLogTool;
import com.vondear.rxtools.RxTool;

import top.lixb.libcommon.BuildConfig;

public class BaseApplication extends Application {

    protected static BaseApplication sApp;

    public Activity getCurActivity() {
        return curActivity;
    }

    protected Activity curActivity;
    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        RxTool.init(this);
        RxLogTool.init(this);
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
            ARouter.printStackTrace();
        }
        ARouter.init(this);
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                curActivity = activity;
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    public static BaseApplication getApp() {
        return sApp;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }


}
