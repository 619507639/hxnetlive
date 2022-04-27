package com.hxinternet.hxtalk.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hxinternet.hxtalk.R;

import butterknife.ButterKnife;

/**
 * create time: 2021/1/19
 * author: bruce
 * description:
 */
public class RankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    public RankAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_rank, parent, false);
            return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {

        } catch (Exception e) {
        }
    }


    @Override
    public int getItemCount() {
        return 24;
    }

    class TableViewHolder extends RecyclerView.ViewHolder {

        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
