package com.nju.meanlay.hiking.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nju.meanlay.hiking.R;

public class BaseActivity extends AppCompatActivity {
    ImageView back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        LayoutInflater inflater = this.getLayoutInflater();
        ViewGroup parent = (ViewGroup) inflater.inflate(R.layout.activity_base,null);
        View contentView = inflater.inflate(layoutResID,null);
        ViewGroup container = parent.findViewById(R.id.container);
        container.addView(contentView);
        Toolbar toolbar = (Toolbar) parent.findViewById(R.id.toolbar);
        back = parent.findViewById(R.id.back);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        super.setContentView(parent);
    }

    protected void enableBack(){
        back = findViewById(R.id.back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
