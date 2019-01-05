package com.nju.meanlay.hiking.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.nju.meanlay.hiking.R;

public class CustomItemView extends FrameLayout {
    private TextView titleTV;
    private TextView contentTV;
    private LayoutInflater layoutInflater;
    private Boolean enableEdit= false;

    public CustomItemView(Context context) {
        this(context,null);
    }

    public CustomItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public CustomItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
        if(attrs != null) {
            int count = attrs.getAttributeCount();
            for(int i = 0; i < count; i++){
                int attrResId = attrs.getAttributeNameResource(i);
                switch (attrResId){
                    case R.attr.customItemEnableEdit:
                        enableEdit = attrs.getAttributeBooleanValue(i,false);
                    case R.attr.customItemTitle:
                        titleTV.setText(attrs.getAttributeValue(i));
                        break;
                    case R.attr.customItemContent:
                        contentTV.setText(attrs.getAttributeValue(i));
                        break;
                }
            }

        }
    }

    private void initView(){
        layoutInflater = LayoutInflater.from(getContext());
        FrameLayout customView = (FrameLayout) layoutInflater.inflate(R.layout.custom_item_view,this);
        titleTV = customView.findViewById(R.id.title_custom);
        contentTV = customView.findViewById(R.id.content_custom);

    }
}
