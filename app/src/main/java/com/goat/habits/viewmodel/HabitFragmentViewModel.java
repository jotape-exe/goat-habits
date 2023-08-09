package com.goat.habits.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.goat.habits.persistence.model.HabitModel;
import com.goat.habits.persistence.repository.HabitRepository;

import java.util.List;

public class HabitFragmentViewModel extends AndroidViewModel {
    HabitRepository repository;

    public HabitFragmentViewModel(@NonNull Application application) {
        super(application);

        repository = new HabitRepository(application.getApplicationContext());
    }

    //Contexto de uso -> viewModel
    private final MutableLiveData<List<HabitModel>> mutableHabitList = new MutableLiveData<>();

    //Contexto de uso -> Activity
    public LiveData<List<HabitModel>> habitList = mutableHabitList;


    public void insert(HabitModel habit){
        repository.insert(habit);
    }

    public void update(HabitModel habit){
        repository.update(habit);
    }

    public void delete(Long id){
        repository.delete(id);
    }

    //Atribui os dados que serão observados na Activity
    public void findAll(){
        mutableHabitList.setValue(repository.findAll());
    }


}
