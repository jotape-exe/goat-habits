package com.goat.habits.ui;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.goat.habits.R;
import com.goat.habits.databinding.ActivityMainBinding;
import com.goat.habits.preferences.UserPreferences;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarMain);

        navigationView = binding.navigationViewMain;

        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.item_habit){
                switchFragment(new HabitFragment());
            } else if (item.getItemId() == R.id.item_achievements) {
                switchFragment(new AchievementsFragment());
            } else if (item.getItemId() == R.id.item_pomodoro) {
                switchFragment(new PomodoroFragment());
            }

            binding.drawerLayoutMain.closeDrawer(GravityCompat.START);

            return true;
        });

        binding.floatingActionButton.setOnClickListener(view -> {
            startActivity(new Intent(this, HabitManagerActivity.class));
        });

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayoutMain, binding.toolbarMain, R.string.open_nav, R.string.close_nav);

        binding.drawerLayoutMain.addDrawerListener(drawerToggle);

        drawerToggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new HabitFragment()).commit();
            navigationView.setCheckedItem(R.id.item_habit);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        View headerView = navigationView.getHeaderView(0);

        setNameTextMenu(headerView);

        headerView.setOnClickListener(view -> {
            startActivity(new Intent(this, StartActivity.class));
        });

    }

    private void setNameTextMenu(View headerView) {
        TextView textNav = headerView.findViewById(R.id.textNav);

        textNav.setText(new UserPreferences(this).getNamePreferences("NAME"));
    }

    private void switchFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, fragment).commit();
    }



}