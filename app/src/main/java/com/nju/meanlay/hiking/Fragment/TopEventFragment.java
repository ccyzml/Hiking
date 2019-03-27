package com.nju.meanlay.hiking.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nju.meanlay.hiking.Activity.EventDetailActivity;
import com.nju.meanlay.hiking.Adapter.EventItemAdapter;
import com.nju.meanlay.hiking.DB.DataCenter;
import com.nju.meanlay.hiking.Interface.OnRecyclerItemClickListener;
import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.R;

import java.util.ArrayList;
import java.util.Arrays;

public class TopEventFragment extends Fragment {
    RecyclerView eventRecyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    private EventItemAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public EventItemAdapter getAdapter() {
        return adapter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_event, container, false);
        eventRecyclerView = view.findViewById(R.id.event_recyclerView);
        swipeRefreshLayout = view.findViewById(R.id.swipe_layout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        eventRecyclerView.setLayoutManager(layoutManager);
        adapter = new EventItemAdapter(getContext(),DataCenter.getInstance().getEvents());
        eventRecyclerView.setAdapter(adapter);
        adapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener<Event>() {

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

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },1000);
            }
        });

        return view;
    }
}
