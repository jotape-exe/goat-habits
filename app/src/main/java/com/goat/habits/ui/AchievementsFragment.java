package com.goat.habits.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goat.habits.R;
import com.goat.habits.databinding.FragmentAchievementsBinding;
import com.goat.habits.preferences.UserPreferences;
import com.goat.habits.ui.adapter.AchievementAdapter;
import com.goat.habits.viewmodel.AchievementViewModel;
import com.goat.habits.viewmodel.HabitFragmentViewModel;


public class AchievementsFragment extends Fragment {

    private FragmentAchievementsBinding binding;
    private AchievementViewModel viewModel;
    private AchievementAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAchievementsBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(AchievementViewModel.class);

        adapter = new AchievementAdapter();

        binding.recyclerAchievement.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerAchievement.setAdapter(adapter);

        viewModel.achievementList.observe(getViewLifecycleOwner(), achievementList -> {
            adapter.updateList(achievementList);
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.findAll();
    }
}