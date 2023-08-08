package com.goat.habits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;

import com.goat.habits.databinding.ActivityHabitManagerBinding;
import com.goat.habits.viewmodel.HabitFragmentViewModel;

public class HabitManagerActivity extends AppCompatActivity {

    ActivityHabitManagerBinding binding;
    HabitFragmentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHabitManagerBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(HabitFragmentViewModel.class);

        setContentView(binding.getRoot());

        binding.buttonSaveHabit.setOnClickListener(view -> {
            if (fieldsValid()){
                //viewModel
            }
        });



    }

    private Boolean fieldsValid() {
        if (TextUtils.isEmpty(binding.editNameHabit.getText())){
            binding.editNameHabit.setError("Nome não pode ser vazio!");
            return false;
        } else if (TextUtils.isEmpty(binding.editDescriptionHabit.getText())){
            binding.editDescriptionHabit.setError("Descrição não pode ser vazio!");
            return false;
        }
        return true;
    }
}