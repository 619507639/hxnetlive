package com.hxinternet.hxtalk.ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hxinternet.hxtalk.R;
import com.hxinternet.hxtalk.ui.Activity.AnchorDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * create time: 2021/1/19
 * author: bruce
 * description:
 */
public class Recommand_AnchorItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    public Recommand_AnchorItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_anchor, parent, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            switch (position)
            {
                case 1:
                    ((TableViewHolder)holder).img_anchor.setBackground(mContext.getResources().getDrawable(R.mipmap.anchor_2));
                    break;
                case 2:
                    ((TableViewHolder)holder).img_anchor.setBackground(mContext.getResources().getDrawable(R.mipmap.anchor_3));
                    break;
                case 3:
                    ((TableViewHolder)holder).img_anchor.setBackground(mContext.getResources().getDrawable(R.mipmap.anchor_4));
                    break;
            }
            ((TableViewHolder)holder).anchor_detail.setOnClickListener(view -> {
                Intent _Intent=new Intent(mContext, AnchorDetailActivity.class);
                mContext.startActivity(_Intent);
            });

        } catch (Exception e) {
        }
    }


    @Override
    public int getItemCount() {
        return 4;
    }

    class TableViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_anchor)
        ImageView img_anchor;
        @BindView(R.id.anchor_detail)
        RelativeLayout anchor_detail;

        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
