package com.nju.meanlay.hiking.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nju.meanlay.hiking.Interface.OnRecyclerItemClickListener;
import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventItemAdapter extends RecyclerView.Adapter<EventItemAdapter.EventItemHolder> {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private ArrayList<Event> events;
    private OnRecyclerItemClickListener<Event> listener;

    public EventItemAdapter(Context context, ArrayList<Event> events) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.events = events;
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

    @Override
    public void onBindViewHolder(@NonNull EventItemHolder holder, int position) {
        Event event = events.get(position);
        holder.title.setText(event.getTitle());
        holder.itemView.setTag(events.get(position));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class EventItemHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        EventItemHolder(View v) {
            super(v);
            img = v.findViewById(R.id.img_event_item);
            title = v.findViewById(R.id.title_event_item);
        }

    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.listener = listener;
    }
}
