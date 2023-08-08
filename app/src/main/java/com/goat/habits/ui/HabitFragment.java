package com.goat.habits.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.goat.habits.databinding.FragmentHabitBinding;

public class HabitFragment extends Fragment {

    FragmentHabitBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHabitBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}