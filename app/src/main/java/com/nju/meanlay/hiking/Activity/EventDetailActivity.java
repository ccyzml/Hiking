package com.nju.meanlay.hiking.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nju.meanlay.hiking.Adapter.UserGridItemAdapter;
import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.Model.EventMember;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;

import java.util.ArrayList;
import java.util.Arrays;

public class EventDetailActivity extends BaseActivity {
    private Event event;
    private RecyclerView waitingRecyclerView;
    private RecyclerView joinedRecyclerView;
    private UserGridItemAdapter waitingAdapter;
    private UserGridItemAdapter joinedAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event_detail);
        enableBack();
        Intent intent = getIntent();
        event = (Event) intent.getSerializableExtra("event");
        waitingRecyclerView = findViewById(R.id.waiting_recycler_view);
        joinedRecyclerView = findViewById(R.id.joined_recycler_view);
        LinearLayoutManager waitingLayoutManager = new LinearLayoutManager(this);
        waitingLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager joinedLayoutManager = new LinearLayoutManager(this);
        joinedLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        waitingRecyclerView.setLayoutManager(waitingLayoutManager);
        joinedRecyclerView.setLayoutManager(joinedLayoutManager);
        waitingAdapter = new UserGridItemAdapter(this,new ArrayList<EventMember>(Arrays.asList(event.getWaitingMembers())));
        joinedAdapter = new UserGridItemAdapter(this,new ArrayList<EventMember>(Arrays.asList(event.getJoinedMembers())));
        waitingRecyclerView.setAdapter(waitingAdapter);
        joinedRecyclerView.setAdapter(joinedAdapter);
    }
}
