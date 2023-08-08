package com.goat.habits.persistence.repository;

import android.content.Context;

import com.goat.habits.persistence.GoatHabitsDatabase;
import com.goat.habits.persistence.dao.HabitDAO;
import com.goat.habits.persistence.model.HabitModel;

import java.util.List;

public class HabitRepository {

    private final HabitDAO database;

    public HabitRepository(Context context){
        database = GoatHabitsDatabase.getDbInstance(context).getHabitDAO();
    }

    public void insert(HabitModel habit){
        database.insert(habit);
    }

    public void update(HabitModel habitModel){
        database.update(habitModel);
    }

    public void delete(Long id){
        HabitModel habit = findById(id);
        database.delete(habit);
    }

    public HabitModel findById(Long id){
        return database.findById(id);
    }

    public List<HabitModel> findAll(){
        return database.findAll();
    }
}
