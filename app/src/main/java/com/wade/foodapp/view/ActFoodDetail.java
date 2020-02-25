package com.wade.foodapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wade.foodapp.bean.FoodBean;
import com.wade.foodapp.R;

/**
 * Created by Wade on 2020/2/16.
 */
public class ActFoodDetail extends AppCompatActivity {
    private Toolbar mToolbar;
    private ImageView mImgView;
    private TextView mTxtName,mTxtAddress,mTxtTel,mTxtFeature;
    private FoodBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        init();
        initToolbar();
    }

    private void init(){
        Intent intent = getIntent();
        bean = intent.getParcelableExtra(getResources().getString(R.string.foodbean));

        mToolbar = findViewById(R.id.mToolbar);
        mImgView = findViewById(R.id.mImgView);
        mTxtName = findViewById(R.id.mTxtName);
        mTxtAddress = findViewById(R.id.mTxtAddress);
        mTxtTel = findViewById(R.id.mTxtTel);
        mTxtFeature = findViewById(R.id.mTxtFeature);

        mToolbar.setTitle("美食資訊");
        mToolbar.inflateMenu(R.menu.toolbar_menu);

        Glide.with(this)
                .load(bean.getPicURL())
                .error(R.mipmap.ic_launcher)
                .into(mImgView);
        mTxtName.setText(bean.getName());
        mTxtAddress.setText(bean.getAddress());
        mTxtTel.setText(bean.getTel());
        mTxtFeature.setText(bean.getFoodFeature());
    }

    private void initToolbar(){
//        //加入引響toolbar_menu顯示
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);

        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                Intent intent = new Intent();
                Uri uri;
                switch (id){
                    case R.id.tel:
                        intent.setAction(Intent.ACTION_DIAL);
                        uri = Uri.parse("tel:" + bean.getTel());
                        intent.setData(uri);
                        startActivity(intent);
                        break;
                    case R.id.map:
                        uri = Uri.parse("google.navigation:q=" + bean.getCoordinate() + "&mode=d");
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(uri);
                        intent.setPackage("com.google.android.apps.maps");
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });
    }
}
