package com.goat.habits.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goat.habits.R;
import com.goat.habits.databinding.FragmentAchievementsBinding;


public class AchievementsFragment extends Fragment {

    FragmentAchievementsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAchievementsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}