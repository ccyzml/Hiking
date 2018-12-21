package com.nju.meanlay.hiking.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class EventRecyclerView extends RecyclerView {
    public EventRecyclerView(Context context) {
        this(context,null);
    }

    public EventRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public EventRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
