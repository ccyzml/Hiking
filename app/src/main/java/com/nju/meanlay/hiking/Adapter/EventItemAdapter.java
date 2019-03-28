package com.nju.meanlay.hiking.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nju.meanlay.hiking.App;
import com.nju.meanlay.hiking.Interface.OnRecyclerItemClickListener;
import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.Model.TestUser;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;
import com.nju.meanlay.hiking.Utils.DateUtils;

import java.util.ArrayList;

public class EventItemAdapter extends RecyclerView.Adapter<EventItemAdapter.EventItemHolder> {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private ArrayList<Event> events;
    private ArrayList<Event> filterEvents;
    private OnRecyclerItemClickListener<Event> listener;
    private boolean isFilter = false;
    private boolean enableCollecting = true;

    public EventItemAdapter(Context context, ArrayList<Event> events) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.events = events;
        filterEvents = new ArrayList<>();
    }

    @NonNull
    @Override
    public EventItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EventItemHolder eventItemHolder = new EventItemHolder(mLayoutInflater.inflate(R.layout.event_item,parent,false));
        eventItemHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v, (Event) v.getTag());
                }
            }
        });
        return eventItemHolder;
    }

    public void filter(String s){
        isFilter = true;
        filterEvents.clear();
        for (Event event:events) {
            if (event.getTitle().contains(s)) {
                filterEvents.add(event);
            }
        }
        notifyDataSetChanged();
    }

    public void cancelFilter() {
        isFilter = false;
        notifyDataSetChanged();
    }

    public void enableCollecting(boolean b) {
        enableCollecting = b;
    }

    @Override
    public void onBindViewHolder(@NonNull EventItemHolder holder, int position) {
        Event event;
        if (isFilter) {
            event = filterEvents.get(position);
        } else {
            event = events.get(position);
        }
        holder.title.setText(event.getTitle());
        holder.itemView.setTag(events.get(position));
        holder.dateTV.setText(event.getDate());
        holder.locationTV.setText(event.getLocation());
        holder.memberCountTV.setText("参与人数： "+event.getJoinedMembers().length+"/"+event.getMemberCount());
        if (event.getFee() == 0) {
            holder.feeTV.setText("免费");
        } else {
            holder.feeTV.setText(event.getFee() + "");
        }
        if (enableCollecting) {
            holder.collectV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TestUser.getUser().collect(event);
                    holder.collectV.setImageResource(R.mipmap.collected);
                    Toast.makeText(mContext,"已收藏",Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            holder.collectV.setVisibility(View.GONE);
        }
        holder.pb.setMax(DateUtils.getRestDays(event.getStartDate(),event.getDate()));
        holder.pb.setProgress(DateUtils.getRestDays(event.getStartDate(),App.getInstance().getNowDate()));
        Glide.with(mContext).load(Integer.valueOf(event.getImgUrl())).into(holder.img);
    }

    @Override
    public int getItemCount() {
        if (isFilter) {
            return filterEvents.size();
        } else {
            return events.size();
        }
    }

    public static class EventItemHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        private ProgressBar pb;
        private TextView dateTV;
        private TextView memberCountTV;
        private TextView locationTV;
        private TextView feeTV;
        private ImageView collectV;
        EventItemHolder(View v) {
            super(v);
            img = v.findViewById(R.id.img_event_item);
            title = v.findViewById(R.id.title_event_item);
            pb = v.findViewById(R.id.progress_event_item);
            dateTV = v.findViewById(R.id.date_event_item);
            memberCountTV = v.findViewById(R.id.member_count_event_item);
            locationTV = v.findViewById(R.id.location_event_item);
            feeTV = v.findViewById(R.id.fee_event_item);
            collectV = v.findViewById(R.id.collect);
        }

    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.listener = listener;
    }
}
