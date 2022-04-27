package com.hxinternet.hxtalk.ui.Adapter;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hxinternet.hxtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * create time: 2021/1/19
 * author: bruce
 * description:
 */
public class AnchorBannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    public AnchorBannerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.banner_anchor, parent, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            switch (position)
            {
                case 0:
                    ((TableViewHolder)holder).img_anchor.setBackground(mContext.getResources().getDrawable(R.mipmap.anchor_1));
                    break;
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

        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
