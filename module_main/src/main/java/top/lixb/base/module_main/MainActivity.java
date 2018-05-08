package top.lixb.base.module_main;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import top.lixb.base.module_main.databinding.ActivityMainBinding;
import top.lixb.base.module_main.fragment.HomeFragment;
import top.lixb.base.module_main.viewmodel.HomeViewModel;
import top.lixb.libcommon.base.BaseActivity;
import top.lixb.libsrc.router.RouteTable;
import top.lixb.base.module_main.BR;


@Route(path = RouteTable.mainHome)
public class MainActivity extends BaseActivity<ActivityMainBinding,HomeViewModel> implements OnTabSelectListener {

    private List<Fragment> mFragments = new ArrayList(){
        {
            add(HomeFragment.newInstance());
            add(HomeFragment.newInstance());
            add(HomeFragment.newInstance());
        }
    };
    private ViewPager mVpContent;
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomBar = (BottomBar) findViewById(R.id.main_bottomBar);
        mVpContent = (ViewPager) findViewById(R.id.main_vp);
        setNoTitle();
        setSwipeBackEnable(false);
        initViewPager();
        initBottomBar();

    }

    private void initBottomBar() {
        mBottomBar.setOnTabSelectListener(this);
    }

    private void initViewPager() {
        mVpContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

        });
    }


    @Override
    protected void initBinding(ActivityMainBinding binding) {

    }


    @Override
    public void onTabSelected(int tabId) {
        int pos = 0;
        if (tabId == R.id.tab_0) {
            pos = 0;
        } else if (tabId == R.id.tab_1) {
            pos = 1;
        } else if (tabId == R.id.tab_2) {
            pos = 2;
        }

        mVpContent.setCurrentItem(pos);
    }
}
