package top.lixb.base.module_main.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.vondear.rxtools.RxLogTool;

import me.tatarka.bindingcollectionadapter2.BindingListViewAdapter;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import top.lixb.base.module_main.R;
import top.lixb.base.module_main.BR;
import top.lixb.libcommon.base.BaseViewModel;
import top.lixb.libcommon.config.CommonConfig;
import top.lixb.libcommon.net.CommonCallback;
import top.lixb.libcommon.net.ParamsBuilder;
import top.lixb.libsrc.bean.DriverexamBean;
import top.lixb.libsrc.bean.PicJokeBean;

public class DriverexamViewModel extends BaseViewModel {

    public static final String SORT_NORMAL = "正常排序";
    public static final String SORT_RAND = "随机排序";
    public static final String SUB1 = "科目一";
    public static final String SUB4 = "科目四";
    public String pagenum = "1";
    public String pagesize = CommonConfig.pageSize;


    public final ObservableList<ItemString> items_sort = new ObservableArrayList<>();
    public final ObservableList<ItemString> items_subject = new ObservableArrayList<>();
    public final ObservableList<ItemString> items_type = new ObservableArrayList<>();
    public final BindingListViewAdapter.ItemIds<Object> itemIds = new BindingListViewAdapter.ItemIds<Object>() {
        @Override
        public long getItemId(int position, Object item) {
            return position;
        }
    };
    public final ItemBinding<ItemString> singleItem = ItemBinding.of(BR.item, R.layout.item);


    public class ItemString extends BaseObservable{
        public boolean checkable = true;
        @Bindable
        public int index;
        @Bindable
        public boolean checked;
        public String txt;

        public ItemString(int index, String txt) {
            this.index = index;
            this.txt = txt;
        }

        public int getIndex() {
            return index;
        }

        public boolean isChecked() {
            return checked;
        }

        public boolean onToggleChecked(View v) {
            if (!checkable) {
                return false;
            }
            checked = !checked;
            notifyPropertyChanged(BR.checked);
            if (checked) {
                switch (txt) {
                    case SORT_NORMAL:
                        sort = "normal";
                        break;
                    case SORT_RAND:
                        sort = "rand";
                        break;
                    case SUB1:
                        subject = "1";
                        break;
                    case SUB4:
                        subject = "4";
                        break;
                    default:
                        type = txt;
                        break;
                }
            }
            return true;
        }
    }
    /**
     *排序方式 正常排序normal 随机排序rand 默认normal
     */
    public String sort="normal";

    /**
     *科目类别 1为科目一 4为科目四 默认1
     */
    public String subject="1";

    /**
     *题目类型 分为A1,A3,B1,A2,B2,C1,C2,C3,D,E,F 默认C1
     */
    public String type="C1";
    @Override
    public void onCreate() {
        super.onCreate();
        requestData();
        items_sort.add(new ItemString(0, SORT_NORMAL));
        items_sort.add(new ItemString(1, SORT_RAND));

        items_subject.add(new ItemString(0, SUB1));
        items_subject.add(new ItemString(1, SUB4));

        items_type.add(new ItemString(0,"A1"));
        items_type.add(new ItemString(1,"A2"));
        items_type.add(new ItemString(2,"A3"));
        items_type.add(new ItemString(3,"B1"));
        items_type.add(new ItemString(4,"B2"));
        items_type.add(new ItemString(5,"C1"));
        items_type.add(new ItemString(6,"C2"));
        items_type.add(new ItemString(7,"C3"));
        items_type.add(new ItemString(8,"D"));
        items_type.add(new ItemString(9,"E"));
        items_type.add(new ItemString(10,"F"));
    }


    public ObservableArrayList<DriverexamBean.ResultBean.ListBean> driveritems = new ObservableArrayList<>();
    public final BindingRecyclerViewAdapter<DriverexamBean.ResultBean.ListBean> adapter = new BindingRecyclerViewAdapter<>();
    public final ItemBinding<DriverexamBean.ResultBean.ListBean> singleDriverItem = ItemBinding.of(BR.item, R.layout.main_item_api_driverexam);
    public final BindingRecyclerViewAdapter.ViewHolderFactory viewHolder = new BindingRecyclerViewAdapter.ViewHolderFactory() {
        @Override
        public RecyclerView.ViewHolder createViewHolder(ViewDataBinding binding) {
            return new MyAwesomeViewHolder(binding.getRoot());
        }
    };
    private RefreshLayout mRefreshLayout;


    public static class MyAwesomeViewHolder extends RecyclerView.ViewHolder {
        public MyAwesomeViewHolder(View itemView) {
            super(itemView);
        }
    }

    private void requestData() {
        performGetRequest(CommonConfig.url_driverexam, "driverexam/query", new ParamsBuilder()
                .addP("pagenum", pagenum)
                .addP("pagesize", pagesize)
                .addP("sort", sort)
                .addP("subject", subject)
                .addP("type", type)
                .build(), new CommonCallback() {
            @Override
            public void onResponse(String response) {
                RxLogTool.e("driver"+response);
                DriverexamBean driverexamBean = new Gson().fromJson(response, DriverexamBean.class);
                driveritems.addAll(driverexamBean.result.list);
            }

            @Override
            public void onError(Throwable e) {
                
            }
        });
    }
}
