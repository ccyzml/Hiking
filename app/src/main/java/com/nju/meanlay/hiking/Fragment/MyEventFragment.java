package com.nju.meanlay.hiking.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nju.meanlay.hiking.Activity.EventDetailActivity;
import com.nju.meanlay.hiking.Adapter.StickyHeaderEventItemAdapter;
import com.nju.meanlay.hiking.DB.DataCenter;
import com.nju.meanlay.hiking.Interface.OnRecyclerItemClickListener;
import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.R;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;
import java.util.Arrays;

public class MyEventFragment extends Fragment {
    RecyclerView mRecyclerView;
    StickyHeaderEventItemAdapter mAdapter;
    ArrayList<Event> events;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        events = new ArrayList<Event>(Arrays.asList(DataCenter.getInstance().getEvents()));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_event, container, false);
        mRecyclerView = view.findViewById(R.id.my_event_recycler_view);
        mAdapter = new StickyHeaderEventItemAdapter(getContext(),events);
        mAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener<Event>() {

            @Override
            public void onClick(View v, Event data) {
                Intent intent = new Intent(getContext(),EventDetailActivity.class);
                intent.putExtra("event",data);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View v, Event data) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new StickyRecyclerHeadersDecoration(mAdapter));
        return view;
    }
}
