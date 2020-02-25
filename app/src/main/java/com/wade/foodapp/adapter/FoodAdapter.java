package com.wade.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wade.foodapp.R;
import com.wade.foodapp.bean.FoodBean;
import com.wade.foodapp.bean.HistoryBean;
import com.wade.foodapp.utils.SPFactory;
import com.wade.foodapp.utils.ToolFactory;
import com.wade.foodapp.view.ActFoodDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wade on 2020/2/16.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{
    private List<FoodBean> list = new ArrayList<>();
    private List<HistoryBean> listHistory = new ArrayList<>();
    private Context mContext;

    public FoodAdapter(Context mContext, List<FoodBean> list){
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_food,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext)
                .load(list.get(position).getPicURL())
                .error(R.mipmap.ic_launcher)
                .into(holder.mImgView);
        holder.mTxtName.setText(list.get(position).getName());
        holder.mTxtAddress.setText(list.get(position).getAddress());
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodBean bean = list.get(position);

                SPFactory spFactory = new SPFactory(mContext,mContext.getResources().getString(R.string.SP_HISTORY));

                listHistory = spFactory.getData(mContext.getResources().getString(R.string.HISTORY_BEAN), HistoryBean.class);

                HistoryBean historyBean = new HistoryBean(ToolFactory.getDateTime("yyyy/MM/dd"),
                        bean.getID(),bean.getName(),ToolFactory.getDateTime("HH:mm:ss"));
                listHistory.add(historyBean);

                spFactory.setData(mContext.getResources().getString(R.string.HISTORY_BEAN),listHistory);

                Intent intent = new Intent(mContext, ActFoodDetail.class);
                intent.putExtra(mContext.getString(R.string.foodbean),bean);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateData(List<FoodBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mLinearLayout;
        CardView mCardView;
        ImageView mImgView;
        TextView mTxtName,mTxtAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLinearLayout = itemView.findViewById(R.id.mLinearLayout);
            mCardView = itemView.findViewById(R.id.mCardView);
            mImgView = itemView.findViewById(R.id.mImgView);
            mTxtName = itemView.findViewById(R.id.mTxtName);
            mTxtAddress = itemView.findViewById(R.id.mTxtAddress);
        }
    }
}
