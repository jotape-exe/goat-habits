package com.goat.habits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.goat.habits.databinding.ActivityMainBinding;
import com.goat.habits.ui.AchievementsFragment;
import com.goat.habits.ui.HabitFragment;
import com.goat.habits.ui.PomodoroFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarMain);

        NavigationView navigationView = binding.navigationViewMain;

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

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayoutMain,
                binding.toolbarMain,
                R.string.open_nav,
                R.string.close_nav);

        binding.drawerLayoutMain.addDrawerListener(drawerToggle);

        drawerToggle.syncState();

        if (savedInstanceState == null){
            //Set Habit fragment por default
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new HabitFragment()).commit();
            navigationView.setCheckedItem(R.id.item_habit);
        }


    }

    private Boolean switchFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, fragment).commit();
        return true;
    }

}