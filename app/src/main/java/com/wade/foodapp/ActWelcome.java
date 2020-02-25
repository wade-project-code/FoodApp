package com.wade.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

/**
 * Created by Wade on 2020/2/16.
 */
public class ActWelcome extends AppCompatActivity {
    private static final int GOTO_ACT_MAIN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        mHandler.sendEmptyMessageDelayed(GOTO_ACT_MAIN, 4000);
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case GOTO_ACT_MAIN:
                    Intent intent = new Intent();
                    intent.setClass(ActWelcome.this, ActMain.class);
                    startActivity(intent);
                    finish();
                    break;
                default:
                    break;
            }
        }

    };

}
