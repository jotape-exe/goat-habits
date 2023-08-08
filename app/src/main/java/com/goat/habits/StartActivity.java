package com.goat.habits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.goat.habits.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {

    ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStartBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.buttonNext.setOnClickListener(v -> {

            if (TextUtils.isEmpty(binding.editName.getText())){
                binding.editName.setError("Nome não pode estar vazio!");
            } else{
                startActivity(new Intent(this, MainActivity.class));
            }
        });

    }
}