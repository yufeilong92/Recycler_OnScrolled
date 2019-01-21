package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication3
 * @Package com.example.myapplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2019.01.21 上午 9:13
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019
 */
public class RlcAdapter extends RecyclerView.Adapter<RlcAdapter.RlvViewHolder> {
    private Context mContext;
    private List<?> mListDatas;
    private LayoutInflater mInflater;

    public RlcAdapter(Context mContext, List<?> mListDatas) {
        this.mContext = mContext;
        this.mListDatas = mListDatas;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RlvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RlvViewHolder(mInflater.inflate(R.layout.rlv_item, null));
    }

    @Override
    public void onBindViewHolder(RlvViewHolder holder, int position) {
        String vo = (String) mListDatas.get(position);
        holder.mTvContent.setText(vo);
    }

    @Override
    public int getItemCount() {
        return mListDatas.size();
    }

    public class RlvViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvContent;

        public RlvViewHolder(View itemView) {
            super(itemView);
            this.mTvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
