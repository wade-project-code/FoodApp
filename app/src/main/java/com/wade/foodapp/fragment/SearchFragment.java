package com.wade.foodapp.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

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
public class SearchFragment extends Fragment implements VolleyFactory.IGetData{
    private final static String TAG = "SearchFragment";
    private SearchView mSearchView;
    private RecyclerView mRecyclerView;
    private FoodAdapter adapter;
    private List<FoodBean> list,searchList;
    private String searchText = "";

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        mSearchView = view.findViewById(R.id.mSearchView);
        mSearchView.setFocusable(false);
        mRecyclerView = view.findViewById(R.id.mRecyclerView);
        mSearchView.setIconifiedByDefault(false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init(){
        list = new ArrayList<>();
        searchList = new ArrayList<>();

        final VolleyFactory volleyFactory = new VolleyFactory(getContext(),this);
        volleyFactory.SendGet();

        adapter = new FoodAdapter(getContext(), list);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchText = s;

                searchList.clear();
                searchList = new ArrayList<>(list);

                for(int i=searchList.size()-1; i>=0; i--){
                    if(!searchList.get(i).getCity().contains(searchText)){
                        searchList.remove(i);
                    }
                }

                adapter.updateData(searchList);
                mSearchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
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
