package com.bwie.information.myapplication.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    protected Context context;


    public BaseViewHolder(View view, Context context) {
        super(view);
        this.context = context;
    }


    public void initData(Object data){

    }
}
