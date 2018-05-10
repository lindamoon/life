package top.lixb.life;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import top.lixb.libcommon.base.BaseActivity;
import top.lixb.life.databinding.ActivitySplashBinding;
import top.lixb.life.viewmodel.SplashViewModel;

public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> {

    private static final int MSG_FINISH = 101;
    private final int SHOW_TIME = 3000;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_FINISH:
                    mViewModel.goNextAct();
                    finish();
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setNoTitle();
        setSwipeBackEnable(false);

    }

    @Override
    protected void initBinding(ActivitySplashBinding binding) {
        binding.setViewModel(mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mHandler.sendEmptyMessageDelayed(MSG_FINISH, SHOW_TIME);
    }






}
