package com.goat.habits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.goat.habits.databinding.ActivityHabitManagerBinding;
import com.goat.habits.persistence.model.HabitModel;
import com.goat.habits.viewmodel.HabitFragmentViewModel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
                String name =  binding.editNameHabit.getText().toString();
                String description = binding.editDescriptionHabit.getText().toString();
//                String frequency = binding.spinnerFrequency.getSelectedItem().toString();

                Date currentDate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String today = dateFormat.format(currentDate);

                HabitModel habitModel = new HabitModel(name, description, "Diariamente", today);

                viewModel.insert(habitModel);
                viewModel.findAll();

                Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_LONG).show();
                finish();
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