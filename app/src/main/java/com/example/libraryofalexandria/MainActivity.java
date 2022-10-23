package com.example.libraryofalexandria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.libraryofalexandria.fragment.FollowedFragment;
import com.example.libraryofalexandria.fragment.HomeFragment;
import com.example.libraryofalexandria.fragment.PersonalPostsFragment;
import com.example.libraryofalexandria.fragment.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tollbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        frameLayout = findViewById(R.id.frame_layout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        HomeFragment homeFragment = new HomeFragment();
                        selectedFragment(homeFragment);
                        break;

                    case R.id.followed:
                        FollowedFragment followedFragment = new FollowedFragment();
                        selectedFragment(followedFragment);
                        break;

                    case R.id.pposts:
                        PersonalPostsFragment personalPostsFragmentFragment = new PersonalPostsFragment();
                        selectedFragment(personalPostsFragmentFragment);
                        break;

                    case R.id.settings:
                        SettingsFragment settings = new SettingsFragment();
                        selectedFragment(settings);
                        break;
                }
                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    private void selectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.followed:
                Toast.makeText(this, "Followed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pposts:
                Toast.makeText(this, "Personal Posts", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}