package top.lixb.libcommon.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import top.lixb.libcommon.R;

public class BaseActivity extends SwipeBackActivity {
    protected LinearLayout rootLayout;
    protected Toolbar mToolbar;
    protected TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        // 这句很关键，注意是调用父类的方法
        super.setContentView(R.layout.common_activity_base);
        initToolbar();
    }

    @Override
    public void setContentView(int layoutId) {
        setContentView(View.inflate(this, layoutId, null));
    }

    @Override
    public void setContentView(View view) {
        rootLayout = (LinearLayout) findViewById(R.id.common_ll_root);
        if (rootLayout == null) {
            return;
        }
        rootLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        initToolbar();
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        if (getSupportActionBar() != null) {
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }
        findViewById(R.id.common_base_iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitle = mToolbar.findViewById(R.id.common_base_tv_title);
    }

    protected void setNoTitle() {
        mToolbar.setVisibility(View.GONE);
    }

    protected void setTitle(String title) {
        mTitle.setText(title);
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T $(int id) {
        return (T)findViewById(id);
    }

}
