package com.nju.meanlay.hiking.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nju.meanlay.hiking.Adapter.FriendItemAdapter;
import com.nju.meanlay.hiking.DB.DataCenter;
import com.nju.meanlay.hiking.Interface.OnRecyclerItemClickListener;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MyFriendsActivity extends BaseActivity {
    RecyclerView recyclerView;
    FriendItemAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_friends);
        enableBack();
        recyclerView = findViewById(R.id.recyclerview_my_friends);
        adapter = new FriendItemAdapter(this,DataCenter.getInstance().getUsers());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onClick(View v, Object data) {
                Intent intent = new Intent(MyFriendsActivity.this,ProfileActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View v, Object data) {

            }
        });
    }
}
