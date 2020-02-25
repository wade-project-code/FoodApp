package com.wade.foodapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wade.foodapp.fragment.AboutFragment;
import com.wade.foodapp.fragment.HistoryFragment;
import com.wade.foodapp.fragment.HomeFragment;
import com.wade.foodapp.fragment.SearchFragment;

/**
 * Created by Wade on 2020/2/16.
 */
public class ActFoodMenu extends ActBase {
    private final static String TAG = "ActFoodMenu";
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        mBottomNavigationView = findViewById(R.id.mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(mBottomNavigationView_Listener);

        loadFragment(HomeFragment.newInstance());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mBottomNavigationView_Listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.HomeFragment:
                    loadFragment(HomeFragment.newInstance());
                    return true;
                case R.id.SearchFragment:
                    loadFragment(SearchFragment.newInstance());
                    return true;
                case R.id.HistoryFragment:
                    loadFragment(HistoryFragment.newInstance());
                    return true;
                case R.id.AboutFragment:
                    loadFragment(AboutFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mFrameLayout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
