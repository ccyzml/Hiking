package com.nju.meanlay.hiking.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.nju.meanlay.hiking.Interface.OnRecyclerItemClickListener;
import com.nju.meanlay.hiking.Model.EventMember;
import com.nju.meanlay.hiking.R;

import java.util.ArrayList;

public class UserGridItemAdapter extends RecyclerView.Adapter<UserGridItemAdapter.UserGridItemHolder> {
    private ArrayList<EventMember> eventMembers;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;


    private OnRecyclerItemClickListener<EventMember> listener;

    public UserGridItemAdapter(Context context,ArrayList<EventMember> eventMembers) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.eventMembers = eventMembers;

    }

    @NonNull
    @Override
    public UserGridItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserGridItemHolder userGridItemHolder = new UserGridItemHolder(mLayoutInflater.inflate(R.layout.user_grid_item,parent,false));
        userGridItemHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v,(EventMember) v.getTag());
                }
            }
        });

        return userGridItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserGridItemHolder holder, int position) {
        EventMember member = eventMembers.get(position);
        holder.universityTV.setText(member.getUniversity());
        holder.nameTV.setText(member.getNickName());
        holder.itemView.setTag(eventMembers.get(position));
    }

    @Override
    public int getItemCount() {
        return eventMembers.size();
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.listener = listener;
    }

    public static class UserGridItemHolder extends RecyclerView.ViewHolder {
         private TextView nameTV;
         private TextView universityTV;
         UserGridItemHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.user_grid_name);
            universityTV = itemView.findViewById(R.id.user_grid_university);
        }
    }

}
