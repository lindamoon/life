package top.lixb.life;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.vondear.rxtools.RxLogTool;
import com.vondear.rxtools.view.dialog.RxDialogSure;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.lixb.libcommon.base.BaseActivity;
import top.lixb.libsrc.Constants;
import top.lixb.libsrc.bean.AppUpdateBean;
import top.lixb.libsrc.helper.AppUpdateHelper;
import top.lixb.libsrc.helper.UserHelper;
import top.lixb.libsrc.router.RouteTable;

public class SplashActivity extends BaseActivity {

    private static final int MSG_FINISH = 101;
    private final int SHOW_TIME = 2000;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_FINISH:
                    goNextAct();
                    finish();
                    break;
            }
        }
    };

    private void goNextAct() {
        if (UserHelper.isLogin()) {
            //跳转主页
            ARouter.getInstance().build(RouteTable.mainHome).navigation();
        } else {
            //跳转登录页
            ARouter.getInstance().build(RouteTable.loginIndex).navigation();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        setNoTitle();
        mHandler.sendEmptyMessageDelayed(MSG_FINISH, SHOW_TIME);
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

}
