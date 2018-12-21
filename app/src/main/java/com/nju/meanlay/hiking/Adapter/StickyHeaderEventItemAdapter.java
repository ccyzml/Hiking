package com.nju.meanlay.hiking.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.R;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.ArrayList;

public class StickyHeaderEventItemAdapter extends EventItemAdapter implements StickyRecyclerHeadersAdapter<StickyHeaderEventItemAdapter.EventHeaderViewHolder> {
    ArrayList<Event> events;
    public StickyHeaderEventItemAdapter(Context context, ArrayList<Event> events) {
        super(context, events);
        this.events = events;
    }

    @Override
    public long getHeaderId(int position) {
        if(events.get(position).getDate() == "2019-1-1") {
            return 0;
        }
        return 1;
    }

    @Override
    public EventHeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sticky_header, parent, false);
        return new EventHeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(EventHeaderViewHolder holder, int position) {
        if (events.get(position).getDate() == "2019-1-1"){
            holder.tagTV.setText("今天");
        } else {
            holder.tagTV.setText("即将到来");
        }
    }

    public static class EventHeaderViewHolder extends RecyclerView.ViewHolder {
        private TextView tagTV;
        public EventHeaderViewHolder(View itemView) {
            super(itemView);
            tagTV = itemView.findViewById(R.id.header_tag);
        }
    }
}
