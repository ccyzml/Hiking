package com.nju.meanlay.hiking.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nju.meanlay.hiking.Adapter.FriendItemAdapter;
import com.nju.meanlay.hiking.DB.DataCenter;
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
        adapter = new FriendItemAdapter(this,new ArrayList<User>(Arrays.asList(DataCenter.getInstance().getUsers())));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
