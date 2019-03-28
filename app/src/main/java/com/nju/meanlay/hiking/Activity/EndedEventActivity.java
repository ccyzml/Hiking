package com.nju.meanlay.hiking.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nju.meanlay.hiking.Adapter.EventItemAdapter;
import com.nju.meanlay.hiking.Model.TestUser;
import com.nju.meanlay.hiking.R;

public class EndedEventActivity extends BaseActivity {
    private EventItemAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ended);
        enableBack();
        recyclerView = findViewById(R.id.recyclerview);

        adapter = new EventItemAdapter(this, TestUser.getUser().getEndedEvents());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.enableCollecting(false);
    }
}
