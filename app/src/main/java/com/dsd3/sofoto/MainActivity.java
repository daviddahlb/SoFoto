package com.dsd3.sofoto;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.dsd3.sofoto.fragments.ComposeFragment;
import com.dsd3.sofoto.fragments.PostsFragment;
import com.dsd3.sofoto.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";


    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new ComposeFragment();
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Log.d(TAG, "onNavi: home");
                        // TODO: change fragment to home
                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                        Log.d(TAG, "onNavi: compose");
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_profile:
                        // TODO: change fragment to profile
                        Log.d(TAG, "onNavi: profile");
                        fragment = new ProfileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }

}
