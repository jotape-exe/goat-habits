package com.goat.habits.persistence.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.goat.habits.persistence.model.AchievementModel;

import java.util.List;

@Dao
public interface AchievementDAO {

    @Insert
    public void insert(AchievementModel achievement);

    @Update
    public void update(AchievementModel achievement);

    @Delete
    public void delete(AchievementModel achievement);

    @Query("SELECT * FROM achievements WHERE id = :id")
    public AchievementModel findById(Long id);

    @Query("SELECT * FROM achievements")
    public List<AchievementModel> findAll();

}
