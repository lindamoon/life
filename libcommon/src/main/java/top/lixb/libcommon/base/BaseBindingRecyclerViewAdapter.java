package top.lixb.libcommon.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;


public abstract class BaseBindingRecyclerViewAdapter<Bean extends IBindingItem> extends RecyclerView.Adapter<AbsBindingViewHolder<Bean>> {

    private final int mCommonLayoutId;

    public List<Bean> getItems() {
        return mItems;
    }

    public void setItems(List<Bean> items) {
        mItems = items;
    }

    public List<Bean> mItems = new ArrayList<>();

    public BaseBindingRecyclerViewAdapter(int commonLayoutId) {
        mCommonLayoutId = commonLayoutId;
    }


    @NonNull
    @Override
    public AbsBindingViewHolder<Bean> onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = View.inflate(parent.getContext(), mCommonLayoutId, null);
        return new AbsBindingViewHolder<Bean>(view) {
            @Override
            protected int initVariableId() {
                return BaseBindingRecyclerViewAdapter.this.initVariableId(viewType);
            }
        };
    }

    protected abstract int initVariableId(int viewType);

    @Override
    public void onBindViewHolder(@NonNull AbsBindingViewHolder<Bean> holder, int position) {
        holder.bindData(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
