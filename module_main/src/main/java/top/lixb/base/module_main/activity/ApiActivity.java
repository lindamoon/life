package top.lixb.base.module_main.activity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.ActivityApiBinding;
import top.lixb.base.module_main.fragment.DriverexamFragment;
import top.lixb.base.module_main.fragment.GifJokeFragment;
import top.lixb.base.module_main.fragment.PicJokeFragment;
import top.lixb.base.module_main.fragment.NewsFragment;
import top.lixb.base.module_main.fragment.TextJokeFragment;
import top.lixb.base.module_main.viewmodel.ApiViewModel;
import top.lixb.libcommon.base.BaseActivity;
import top.lixb.libsrc.router.RouteTable;

@Route(path = RouteTable.mainApi)
public class ApiActivity extends BaseActivity<ActivityApiBinding,ApiViewModel> {

    private List<Fragment> mFragments = new ArrayList<Fragment>(){
        {
            add(NewsFragment.newInstance());
            add(DriverexamFragment.newInstance());
            add(PicJokeFragment.newInstance());
            add(TextJokeFragment.newInstance());
            add(GifJokeFragment.newInstance());
        }
    };

    private List<String> titles = new ArrayList<String>(){
        {
            add("新闻头条");
            add("驾考题库查询");
            add("搞笑图片");
            add("搞笑文字");
            add("搞笑GIF");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        setNoTitle();
        mBinding.pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }

        });
        mBinding.tabs.setupWithViewPager(mBinding.pager);


    }


    @Override
    protected void initBinding(ActivityApiBinding binding) {
        binding.setApi(mViewModel);
    }
}
