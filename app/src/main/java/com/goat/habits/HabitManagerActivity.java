package com.goat.habits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.goat.habits.databinding.ActivityHabitManagerBinding;

public class HabitManagerActivity extends AppCompatActivity {

    ActivityHabitManagerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHabitManagerBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());



    }
}