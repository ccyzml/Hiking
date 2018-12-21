package com.nju.meanlay.hiking.Interface;

import android.view.View;

public interface OnRecyclerItemClickListener<T> {
    void onClick(View v, T data);
    void onLongClick(View v,T data);
}

