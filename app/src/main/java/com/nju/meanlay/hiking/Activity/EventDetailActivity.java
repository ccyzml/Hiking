package com.nju.meanlay.hiking.Activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
    private ImageView img;
    private TextView dateTV;
    private TextView locationTV;
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


        img = findViewById(R.id.img_event_detail);
        dateTV = findViewById(R.id.date_event_detail);
        locationTV = findViewById(R.id.location_event_detail);

        Glide.with(this).load(Integer.valueOf(event.getImgUrl())).centerCrop().into(img);
        dateTV.setText(event.getDate());
        locationTV.setText(event.getLocation());
    }
}
