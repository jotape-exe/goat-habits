package com.goat.habits.persistence.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.goat.habits.persistence.model.AchievementModel;
import com.goat.habits.persistence.model.HabitModel;

import java.util.List;

@Dao
public interface HabitDAO {

    @Insert
    public void insert(HabitModel habit);

    @Update
    public void update(HabitModel habit);

    @Delete
    public void delete(HabitModel habit);

    @Query("SELECT * FROM habits WHERE id = :id")
    public HabitModel findById(Long id);

    @Query("SELECT * FROM habits")
    public List<HabitModel> findAll();
}
