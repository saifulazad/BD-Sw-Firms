package com.jokerslab.android.bd_sw_firms;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sayem on 9/8/2017.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    private int viewType;

    public BaseViewHolder(View itemView, int viewType) {
        super(itemView);
        this.viewType = viewType;
    }

    public abstract void bindData(T data);

    public Context getContext() {
        return itemView.getContext();
    }

    public int getViewType() {
        return viewType;
    }
}
