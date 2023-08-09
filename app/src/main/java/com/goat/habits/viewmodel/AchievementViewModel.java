package com.goat.habits.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.goat.habits.persistence.model.AchievementModel;
import com.goat.habits.persistence.repository.AchievementRepository;

import java.util.List;

public class AchievementViewModel extends AndroidViewModel {

    private final AchievementRepository repository;

    public AchievementViewModel(@NonNull Application application) {
        super(application);
        repository = new AchievementRepository(application.getApplicationContext());
    }

    private final MutableLiveData<List<AchievementModel>> mutableAchievementList = new MutableLiveData<>();
    public LiveData<List<AchievementModel>> achievementList = mutableAchievementList;

    public void findAll(){
        mutableAchievementList.setValue(repository.findAll());
    }
}
