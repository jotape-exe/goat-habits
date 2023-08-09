package com.goat.habits.persistence.repository;

import android.content.Context;

import com.goat.habits.persistence.GoatHabitsDatabase;
import com.goat.habits.persistence.dao.AchievementDAO;
import com.goat.habits.persistence.model.AchievementModel;

import java.util.List;

public class AchievementRepository {
    private final AchievementDAO database;

    public AchievementRepository(Context context){
        database = GoatHabitsDatabase.getDbInstance(context).getAchievementDAO();
    }

    public void insert(AchievementModel achievement){
        database.insert(achievement);
    }

    public void update(AchievementModel achievement){
        database.update(achievement);
    }

    public void delete(Long id){
        AchievementModel achievement = findById(id);
        database.delete(achievement);
    }

    public AchievementModel findById(Long id){
        return database.findById(id);
    }

    public List<AchievementModel> findAll(){
        return database.findAll();
    }
}
