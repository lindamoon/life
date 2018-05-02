package top.lixb.life;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.vondear.rxtools.RxLogTool;
import com.vondear.rxtools.view.RxToast;
import com.vondear.rxtools.view.dialog.RxDialog;
import com.vondear.rxtools.view.dialog.RxDialogSure;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.lixb.libcommon.base.BaseActivity;
import top.lixb.libcommon.helper.UserHelper;

public class SplashActivity extends BaseActivity {

    private static final int MSG_FINISH = 101;
    private final int SHOW_TIME = 2000;
    @BindView(R.id.btn_hello)
    Button btnHello;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_FINISH:
                    goNextAct();
                    break;
            }
        }
    };

    private void goNextAct() {
        if (UserHelper.isLogin()) {
            //跳转主页

        } else {
            //跳转登录页
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        setNoTitle();
        mHandler.sendEmptyMessageDelayed(MSG_FINISH, SHOW_TIME);
        RxLogTool.d("Splash onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @OnClick(R.id.btn_hello)
    public void onViewClicked() {
        RxDialogSure rxDialogSure = new RxDialogSure(this);
        rxDialogSure.setContent("进入登录页");
        rxDialogSure.getTitleView().setVisibility(View.GONE);
        rxDialogSure.setSureListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转登录页
                ARouter.getInstance().build("/splash/test").navigation();
            }
        });
        rxDialogSure.show();
    }
}
