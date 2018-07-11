package top.lixb.base.module_main.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.activity.ApiActivity;
import top.lixb.libcommon.refresh.RVViewHolder;
import top.lixb.libcommon.refresh.RefreshFragment;
import top.lixb.libsrc.bean.MainItemBean;
import top.lixb.libsrc.router.RouteTable;

public class HomeFragment extends RefreshFragment {

    private List<MainItemBean> mItemBeans;
    private RecyclerView mRv;
    private SmartRefreshLayout mSrl;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItemBeans = new ArrayList<>();
        mItemBeans.add(new MainItemBean("Api测试", R.mipmap.icon_main_apitest));
        mItemBeans.add(new MainItemBean("操作日志",R.mipmap.icon_main_oplog));
    }


    @Override
    protected void initView(View view) {
        super.initView(view);
        mRv = view.findViewById(R.id.rv);
        mSrl = view.findViewById(R.id.srl);
        mRv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        BaseQuickAdapter<MainItemBean, RVViewHolder> adapter = new BaseQuickAdapter<MainItemBean, RVViewHolder>(R.layout.item_main_home, mItemBeans) {

            @Override
            protected void convert(RVViewHolder helper, MainItemBean item) {
                helper.setImageResource(R.id.iv, item.icon);
                helper.setText(R.id.tv, item.title);
            }
        };
        mRv.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        ARouter.getInstance().build(RouteTable.mainApi).navigation();
                        break;
                    case 1:
                        String URL = "http://119.23.226.159/operatelog/list";
                        ARouter.getInstance().build(RouteTable.mainWeb).withString("url",URL).navigation();
                        break;
                }
            }
        });

        mSrl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

                refreshLayout.finishLoadMore(2000);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

                refreshLayout.finishRefresh(2000);
            }
        });
    }



}
