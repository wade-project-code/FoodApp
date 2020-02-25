package com.wade.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wade.foodapp.R;
import com.wade.foodapp.bean.HistoryBean;
import com.wade.foodapp.utils.SPFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wade on 2020/2/19.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context mContext;
    private List<HistoryBean> list = new ArrayList<>();
    private SPFactory spFactory;

    public HistoryAdapter(Context mContext){
        this.mContext = mContext;
        spFactory = new SPFactory(mContext,mContext.getResources().getString(R.string.SP_HISTORY));
        list = spFactory.getData(mContext.getResources().getString(R.string.HISTORY_BEAN), HistoryBean.class);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_history,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTxtDate.setText(list.get(position).getDate());
        holder.mTxtId.setText(list.get(position).getID());
        holder.mTxtName.setText(list.get(position).getName());
        holder.mTxtTime.setText(list.get(position).getTime());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView mCardView;
        TextView mTxtDate, mTxtId, mTxtName, mTxtTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.mCardView);
            mTxtDate = itemView.findViewById(R.id.mTxtDate);
            mTxtId = itemView.findViewById(R.id.mTxtId);
            mTxtName = itemView.findViewById(R.id.mTxtName);
            mTxtTime = itemView.findViewById(R.id.mTxtTime);
        }
    }
}
