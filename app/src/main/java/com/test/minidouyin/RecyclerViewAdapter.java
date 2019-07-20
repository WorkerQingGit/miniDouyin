package com.test.minidouyin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test.minidouyin.network.NetworkServiceImpl;
import com.test.minidouyin.network.beans.Feed;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;

    private List<Feed> feedList;
    private NetworkServiceImpl networkService = new NetworkServiceImpl();
    public RecyclerViewAdapter(Context mContext,List<Feed> feedList) {
        this.mContext = mContext;
        this.feedList = feedList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_video,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext).load(feedList.get(i).getImageUrl()).into(viewHolder.im_icon);
        viewHolder.tv_name.setText(feedList.get(i).getUserName());
        viewHolder.tv_studentId.setText(feedList.get(i).getStudentId());
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView im_icon;
        TextView tv_name;
        TextView tv_studentId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im_icon = itemView.findViewById(R.id.iv_icon);
            tv_name= itemView.findViewById(R.id.tv_name);
            tv_studentId = itemView.findViewById(R.id.tv_studentid);
        }
    }
}