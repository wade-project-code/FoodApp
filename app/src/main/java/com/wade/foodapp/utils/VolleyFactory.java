package com.wade.foodapp.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wade.foodapp.R;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wade on 2020/2/16.
 */
public class VolleyFactory {
    private static final String TAG = "VolleyFactory";
    private Context context;
    private IGetData iGetData;
    private HashMap hashMap;
    private ProgressDialog progressDialog;

    public interface IGetData{
        void Success(String msg);
        void Error(String msg);
    }

    public VolleyFactory(Context context, IGetData iGetData){
        this.context = context;
        this.iGetData = iGetData;
    }

    public VolleyFactory(Context context, IGetData iGetData, HashMap hashMap){
        this.context = context;
        this.iGetData = iGetData;
        this.hashMap = hashMap;
    }

    public void SendGet(){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("資料下載中...");
        progressDialog.show();

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, context.getResources().getString(R.string.url),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        iGetData.Success(response);
                        //Log.d(TAG,response);
                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        iGetData.Error(error.getMessage());
                        //Log.d(TAG,error.getMessage());
                        progressDialog.dismiss();
                    }
                }){
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String parsed;
                parsed = new String(response.data, StandardCharsets.UTF_8);
                return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
            }
        };

        queue.add(stringRequest);
    }

    public void SendPost(){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("資料下載中...");
        progressDialog.show();

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, context.getResources().getString(R.string.url),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        iGetData.Success(response);
                        //Log.v(TAG,response);
                        progressDialog.hide();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        iGetData.Error(error.getMessage());
                        //Log.d(TAG,error.getMessage());
                        progressDialog.hide();
                    }
                }){
            @Override
            public Map<String, String> getHeaders() {
                return hashMap;
            }

            protected Response<String> parseNetworkResponse(NetworkResponse response)
            {
                String parsed;
                parsed = new String(response.data, StandardCharsets.UTF_8);
                return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
            }
        };

        queue.add(stringRequest);
    }
}
