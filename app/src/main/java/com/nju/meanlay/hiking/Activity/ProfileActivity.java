package com.nju.meanlay.hiking.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nju.meanlay.hiking.R;

public class ProfileActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        enableBack();
    }
}
