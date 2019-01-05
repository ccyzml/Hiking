package com.nju.meanlay.hiking.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nju.meanlay.hiking.Interface.OnRecyclerItemClickListener;
import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;

import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendItemAdapter extends RecyclerView.Adapter<FriendItemAdapter.FriendViewHolder> {

    private Context mContext;
    private ArrayList<User> users;
    private OnRecyclerItemClickListener<User> listener;
    public FriendItemAdapter(Context context, ArrayList<User> users) {
        mContext = context;
        this.users = users;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FriendViewHolder friendViewHolder = new FriendViewHolder(LayoutInflater.from(mContext).inflate(R.layout.friend_item,parent,false));
        friendViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v, (User) v.getTag());
                }
            }
        });
        return friendViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        User user = users.get(position);
        Glide.with(mContext).load(Integer.valueOf(user.getAvatarUrl())).centerCrop().into(holder.avatar);
        holder.name.setText(user.getNickName());
        holder.university.setText(user.getUniversity());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class FriendViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView avatar;
        private TextView name;
        private TextView university;
        public FriendViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar_friend_item);
            name = itemView.findViewById(R.id.name_friend_item);
            university = itemView.findViewById(R.id.university_friend_item);
        }
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.listener = listener;
    }
}
