package com.goat.habits.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.goat.habits.databinding.ActivityHabitManagerBinding;
import com.goat.habits.persistence.model.HabitModel;
import com.goat.habits.viewmodel.HabitFragmentViewModel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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

        loadSpinner();

        binding.buttonSaveHabit.setOnClickListener(view -> {
            if (fieldsValid()) {
                String name = binding.editNameHabit.getText().toString();
                String description = binding.editDescriptionHabit.getText().toString();
                String frequency = binding.spinnerFrequency.getSelectedItem().toString();

                Date currentDate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String today = dateFormat.format(currentDate);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);

                //30 inserções incrementando o dia de 1 em 1
                if (frequency.equals("Diariamente")) {
                    for (int i = 0; i < 30; i++) {
                        HabitModel dailyHabit = new HabitModel(name, description, frequency, "Dia: "+dateFormat.format(calendar.getTime()));
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                        viewModel.insert(dailyHabit);
                    }
                //4 inserções incrementando o dia de 7 em 7
                } else if (frequency.equals("Semanalmente")) {
                    for (int i = 0; i < 4; i++) {
                        HabitModel weeklyHabit = new HabitModel(name, description, frequency, "Dia: "+dateFormat.format(calendar.getTime()));
                        calendar.add(Calendar.DAY_OF_MONTH, 7);
                        viewModel.insert(weeklyHabit);
                    }
                } else if (frequency.equals("Mensalmente")) {
                    HabitModel habitModel = new HabitModel(name, description, frequency, "Dia: "+today);
                    viewModel.insert(habitModel);
                }

                viewModel.findAll();

                Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_LONG).show();
                finish();
            }
        });



    }

    private void loadSpinner() {
        String[] frequency = {
                "Diariamente", "Semanalmente", "Mensalmente"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, frequency);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinnerFrequency.setAdapter(adapter);
    }

    private Boolean fieldsValid() {
        if (TextUtils.isEmpty(binding.editNameHabit.getText())) {
            binding.editNameHabit.setError("Nome não pode ser vazio!");
            return false;
        } else if (TextUtils.isEmpty(binding.editDescriptionHabit.getText())) {
            binding.editDescriptionHabit.setError("Descrição não pode ser vazio!");
            return false;
        }
        return true;
    }
}