package com.nju.meanlay.hiking.Activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nju.meanlay.hiking.Adapter.EventItemAdapter;
import com.nju.meanlay.hiking.Adapter.UserGridItemAdapter;
import com.nju.meanlay.hiking.Interface.OnRecyclerItemClickListener;
import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.Model.EventMember;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;
import com.nju.meanlay.hiking.View.CustomItemView;

import java.util.ArrayList;
import java.util.Arrays;

public class EventDetailActivity extends BaseActivity {
    private Event event;
    private RecyclerView waitingRecyclerView;
    private RecyclerView joinedRecyclerView;
    private UserGridItemAdapter waitingAdapter;
    private UserGridItemAdapter joinedAdapter;
    private ImageView img;
    private ArrayList<EventMember> waitingMembers;
    private ArrayList<EventMember> joinedMembers;
    private CustomItemView locationIV,feeIV,descriptionIV;

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
        waitingMembers = new ArrayList<EventMember>(Arrays.asList(event.getWaitingMembers()));
        joinedMembers = new ArrayList<EventMember>(Arrays.asList(event.getJoinedMembers()));
        waitingAdapter = new UserGridItemAdapter(this,waitingMembers);
        joinedAdapter = new UserGridItemAdapter(this,joinedMembers);
        waitingRecyclerView.setAdapter(waitingAdapter);
        joinedRecyclerView.setAdapter(joinedAdapter);

        waitingAdapter.showAddIcon();
        joinedAdapter.showDeleteIcon();
        img = findViewById(R.id.img_event_detail);

        locationIV = findViewById(R.id.location_event_item);
        feeIV = findViewById(R.id.fee_event_item);
        descriptionIV = findViewById(R.id.description_event_item);

        locationIV.setContent(event.getLocation());
        feeIV.setContent(event.getFee()+"");


        waitingAdapter.setTagListener(new UserGridItemAdapter.TagClickListener<EventMember>() {
            @Override
            public void tagClick(View v, EventMember data) {
                waitingMembers.remove(data);
                joinedMembers.add(data);
                joinedAdapter.notifyDataSetChanged();
                waitingAdapter.notifyDataSetChanged();
            }
        });

        joinedAdapter.setTagListener(new UserGridItemAdapter.TagClickListener<EventMember>() {
            @Override
            public void tagClick(View v, EventMember data) {
                joinedMembers.remove(data);
                joinedAdapter.notifyDataSetChanged();
            }
        });

        waitingAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onClick(View v, Object data) {
                Intent intent = new Intent(EventDetailActivity.this,ProfileActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View v, Object data) {

            }
        });

        joinedAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onClick(View v, Object data) {
                Intent intent = new Intent(EventDetailActivity.this,ProfileActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View v, Object data) {

            }
        });



        Glide.with(this).load(Integer.valueOf(event.getImgUrl())).centerCrop().into(img);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.event_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            finish();
            return true;
        }else if (id == R.id.action_edit) {
            Intent intent = new Intent(EventDetailActivity.this,CreateEventActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
