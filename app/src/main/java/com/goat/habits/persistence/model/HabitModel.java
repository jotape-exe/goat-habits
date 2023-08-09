package com.goat.habits.persistence.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "habits")
public class HabitModel {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    private String description;
    private String frequency;
    @ColumnInfo(name = "start_date")
    private String startDate;

    public HabitModel(Long id, String name, String description, String frequency, String startDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.frequency = frequency;
        this.startDate = startDate;
    }

    public HabitModel(String name, String description, String frequency, String today) {
        this.name = name;
        this.description = description;
        this.frequency = frequency;
        this.startDate = today;
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

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "HabitModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", frequency='" + frequency + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
