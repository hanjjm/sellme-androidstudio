package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.Toast;

public class GPSActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
        GPSFragment.OnFragmentInteractionListener,
        MyPageFragment.OnFragmentInteractionListener {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction transaction = fragmentManager.beginTransaction();
    private HomeFragment homeFragment = new HomeFragment();
    private GPSFragment gpsFragment = new GPSFragment();
    private MyPageFragment myPageFragment = new MyPageFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        transaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction = fragmentManager.beginTransaction();
                    if(!homeFragment.isAdded()) transaction.replace(R.id.frameLayout, homeFragment).commitNowAllowingStateLoss();
                    break;
                case R.id.navigation_dashboard:
                    transaction = fragmentManager.beginTransaction();
                    if(!gpsFragment.isAdded()) transaction.replace(R.id.frameLayout, gpsFragment).commitNowAllowingStateLoss();
                    break;
                case R.id.navigation_notifications:
                    transaction = fragmentManager.beginTransaction();
                    if(!myPageFragment.isAdded()) transaction.replace(R.id.frameLayout, myPageFragment).commitNowAllowingStateLoss();
                    break;
            }
            return true;
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
