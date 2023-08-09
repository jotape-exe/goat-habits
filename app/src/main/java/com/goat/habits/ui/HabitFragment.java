package com.goat.habits.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.goat.habits.databinding.FragmentHabitBinding;
import com.goat.habits.preferences.UserPreferences;
import com.goat.habits.ui.adapter.HabitAdapter;
import com.goat.habits.ui.listener.HabitListener;
import com.goat.habits.viewmodel.HabitFragmentViewModel;

public class HabitFragment extends Fragment {

    public static final String KEY_BUNDLE_ID = "habitId";

    private FragmentHabitBinding binding;
    private HabitFragmentViewModel viewModel;
    private HabitAdapter habitAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHabitBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(HabitFragmentViewModel.class);

        habitAdapter = new HabitAdapter();

        binding.recyclerHabit.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerHabit.setAdapter(habitAdapter);

        viewModel.habitList.observe(getViewLifecycleOwner(), habitModelList -> {
            habitAdapter.updateList(habitModelList);
        });

        HabitListener listener = new HabitListener() {
            @Override
            public void onDelete(Long id) {
                viewModel.delete(id);
                viewModel.findAll();
            }

            @Override
            public void onLongClick(Long id) {
                Bundle bundle = new Bundle();
                bundle.putLong(KEY_BUNDLE_ID,id);
            }

            @Override
            public void onSelectCheckBox() {
                new UserPreferences(requireContext()).setHabitCountPreference("HABIT_COUNT",1L);
            }

        };

        habitAdapter.setListener(listener);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.findAll();
    }
}