package com.nju.meanlay.hiking.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.nju.meanlay.hiking.Interface.OnRecyclerItemClickListener;
import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.Model.EventMember;
import com.nju.meanlay.hiking.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserGridItemAdapter extends RecyclerView.Adapter<UserGridItemAdapter.UserGridItemHolder> {
    private ArrayList<EventMember> eventMembers;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private boolean enableDelete = false;
    private boolean enableAdd = false;


    private OnRecyclerItemClickListener<EventMember> listener;
    private TagClickListener tagListener;


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
        userGridItemHolder.tagIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tagListener != null) {
                    tagListener.tagClick(view, view.getTag());
                }
            }
        });

        return userGridItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserGridItemHolder holder, int position) {
        EventMember member = eventMembers.get(position);
        holder.universityTV.setText(member.getUser().getUniversity());
        holder.nameTV.setText(member.getUser().getNickName());
        holder.itemView.setTag(eventMembers.get(position));
        holder.tagIV.setTag(eventMembers.get(position));
        if (enableDelete) {
            holder.tagIV.setVisibility(View.VISIBLE);
            holder.tagIV.setImageResource(R.mipmap.delete);
        }
        if (enableAdd) {
            holder.tagIV.setVisibility(View.VISIBLE);
            holder.tagIV.setImageResource(R.mipmap.add);
        }
        Glide.with(mContext).load(Integer.valueOf(member.getUser().getAvatarUrl())).centerCrop().into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return eventMembers.size();
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.listener = listener;
    }

    public void setTagListener(TagClickListener<EventMember> listener) {
        this.tagListener = listener;
    }

    public static class UserGridItemHolder extends RecyclerView.ViewHolder {
         private TextView nameTV;
         private TextView universityTV;
         private CircleImageView avatar;
         private ImageView tagIV;
         UserGridItemHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.user_grid_name);
            universityTV = itemView.findViewById(R.id.user_grid_university);
            avatar = itemView.findViewById(R.id.avatar_grid_item);
            tagIV = itemView.findViewById(R.id.tag_grid_item);
        }
    }

    public void showDeleteIcon() {
        enableDelete = true;
    }

    public void showAddIcon() {
        enableAdd = true;
    }

    public interface TagClickListener<T>{
        void tagClick(View v,T data );
    }
}
