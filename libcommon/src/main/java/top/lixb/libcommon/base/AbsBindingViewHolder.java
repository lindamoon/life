package top.lixb.libcommon.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class AbsBindingViewHolder<T extends IBindingItem> extends RecyclerView.ViewHolder {

    private View mItemView;
    private ViewDataBinding mBind;

    public AbsBindingViewHolder(View itemView) {
        super(itemView);
        mItemView = this.itemView;
        mItemView = itemView;
        mBind = DataBindingUtil.bind(itemView);
    }

    public void bindData(T item) {
        mBind.setVariable(initVariableId(), item);
    }

    protected abstract int initVariableId();
}
