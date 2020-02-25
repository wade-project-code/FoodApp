package com.wade.foodapp.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wade.foodapp.bean.FoodBean;
import com.wade.foodapp.R;
import com.wade.foodapp.adapter.FoodAdapter;
import com.wade.foodapp.utils.VolleyFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wade on 2020/2/16.
 */
public class HomeFragment extends Fragment implements VolleyFactory.IGetData {
    private final static String TAG = "HomeFragment";
    private FloatingActionButton mFloatingActionButton;
    private RecyclerView mRecyclerView;
    private FoodAdapter adapter;
    private List<FoodBean> list;
    private boolean isFABClick = true;

    private View.OnClickListener mFloatingActionButton_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(isFABClick){
                mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
                mFloatingActionButton.setImageResource(R.drawable.ic_dehaze_black_24dp);
            }else{
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                mFloatingActionButton.setImageResource(R.drawable.ic_apps_black_24dp);
            }
            isFABClick = !isFABClick;
        }
    };

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = view.findViewById(R.id.mRecyclerView);
        mFloatingActionButton = view.findViewById(R.id.mFloatingActionButton);
        mFloatingActionButton.setOnClickListener(mFloatingActionButton_click);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init(){
        list = new ArrayList<>();

        VolleyFactory volleyFactory = new VolleyFactory(getContext(),this);
        volleyFactory.SendGet();

        adapter = new FoodAdapter(getContext(), list);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void Success(String msg) {
        JsonToObject(msg);
        adapter.updateData(list);
    }

    @Override
    public void Error(String msg) {
        Log.d(TAG,msg);
    }

    private void JsonToObject(String json){
        Gson gson = new Gson();
        list = gson.fromJson(json, new TypeToken<List<FoodBean>>(){}.getType());
    }
}
