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
    @ColumnInfo(name = "meta_daily")
    private int metaDaily;
    private String frequency;
    @ColumnInfo(name = "start_date")
    private String startDate;

    public HabitModel(long id, String name, String description, int metaDaily, String frequency, String startDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.metaDaily = metaDaily;
        this.frequency = frequency;
        this.startDate = startDate;
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

    public int getMetaDaily() {
        return metaDaily;
    }

    public void setMetaDaily(int metaDaily) {
        this.metaDaily = metaDaily;
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
}
