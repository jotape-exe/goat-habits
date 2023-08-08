package com.goat.habits.persistence.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "achievements")
public class AchievementModel {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    private String description;
    private String type;
    private String dateAchievement;

    public AchievementModel(Long id, String name, String description, String type, String dateAchievement) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.dateAchievement = dateAchievement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateAchievement() {
        return dateAchievement;
    }

    public void setDateAchievement(String dateAchievement) {
        this.dateAchievement = dateAchievement;
    }
}
