package com.wade.foodapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wade on 2020/2/19.
 */
public class SPFactory {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SPFactory(Context mContext,String Name){
        sp = mContext.getSharedPreferences(Name,Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public <T> void setData(String key, List<T> list) {
        if (null == list || list.size() <= 0) return;

        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.clear();
        editor.putString(key, json);
        editor.apply();
    }

    public <T> List<T> getData(String key,Class<T> cls) {
        List<T> list = new ArrayList<>();
        String json = sp.getString(key, null);

        if (json == null) {
            return list;
        }

        Gson gson = new Gson();
        JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            list.add(gson.fromJson(jsonElement, cls));
        }

        return list;
    }
}
