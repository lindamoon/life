package top.lixb.life.viewmodel;

import android.content.Context;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;

import top.lixb.libcommon.base.BaseViewModel;
import top.lixb.libsrc.Constants;
import top.lixb.libsrc.bean.AppUpdateBean;
import top.lixb.libsrc.helper.AppUpdateHelper;
import top.lixb.libsrc.helper.UserHelper;
import top.lixb.libsrc.router.RouteTable;

public class SplashViewModel extends BaseViewModel {

    @Override
    public void onCreate() {
        super.onCreate();
        checkAppUpdate();
    }

    private void checkAppUpdate() {
        AppUpdateHelper.getInstance().checkUpdate(new AppUpdateHelper.IUpdateCheckCallback() {
            @Override
            public void onCheckUpdate(boolean hasNewVersion, @Nullable AppUpdateBean bean) {
                if (hasNewVersion) {
                    ARouter.getInstance().build(RouteTable.updateIndex).withObject(Constants.KEY_UPDATE_INFO, bean).navigation();
                }
            }
        });
    }

    public void goNextAct() {
        if (UserHelper.isLogin()) {
            //跳转主页
            ARouter.getInstance().build(RouteTable.mainHome).navigation();
        } else {
            //跳转登录页
            ARouter.getInstance().build(RouteTable.loginIndex).navigation();
        }

    }
}
