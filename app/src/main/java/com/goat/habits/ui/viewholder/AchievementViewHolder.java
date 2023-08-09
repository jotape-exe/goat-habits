package com.goat.habits.ui.viewholder;

import android.graphics.Color;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goat.habits.R;
import com.goat.habits.databinding.ComponentAchievementBinding;
import com.goat.habits.persistence.model.AchievementModel;
import com.goat.habits.preferences.UserPreferences;

import java.util.HashMap;
import java.util.Map;

public class AchievementViewHolder extends RecyclerView.ViewHolder {

    private ComponentAchievementBinding bind;
    private final String COMUM = "Comum";
    private final String RARO = "Raro";
    private final String ÉPICO = "Épico";
    private final String MONSTRO = "Monstro";

    public AchievementViewHolder(@NonNull ComponentAchievementBinding bind) {
        super(bind.getRoot());
        this.bind = bind;
    }

    public void bindData(AchievementModel achievement) {

        bind.textTitleAchievement.setText(achievement.getName());
        bind.textDescriptionAchievement.setText(achievement.getDescription());
        bind.textTagAchievement.setText(achievement.getType());

        changeRarity(achievement.getType());

        Long habitCount = new UserPreferences(itemView.getContext()).getHabitCountPreferences("HABIT_COUNT");

        validateAchievement(habitCount, achievement.getName());

    }

    private void changeRarity(String type) {
        switch (type) {
            case RARO:
                bind.containerRarityText.getBackground().setTint(itemView.getContext().getColor(R.color.blue_v2));
                break;
            case ÉPICO:
                bind.containerRarityText.getBackground().setTint(itemView.getContext().getColor(R.color.purple_v1));
                break;
            case MONSTRO:
                bind.containerRarityText.getBackground().setTint(itemView.getContext().getColor(R.color.yellow));
                bind.textTagAchievement.setTextColor(itemView.getContext().getColor(R.color.black));
                break;
        }
    }

    //Muda o backgroun da conquista se ela for concluida
    private void validateAchievement(Long habitCount, String nameAchievement) {
        Map<String, Long> achievementMap = new HashMap<>();
        achievementMap.put("Cbum", 300L);
        achievementMap.put("Herócio!", 200L);
        achievementMap.put("Lendário", 150L);
        achievementMap.put("Poder do Hábito!", 100L);
        achievementMap.put("Mestre da rotina", 80L);
        achievementMap.put("Experiente", 50L);
        achievementMap.put("Intermediário", 30L);
        achievementMap.put("Iniciante", 20L);
        achievementMap.put("Primeiros passos", 10L);
        achievementMap.put("Engatinhando", 5L);

        for (Map.Entry<String, Long> entry : achievementMap.entrySet()) {
            if (habitCount >= entry.getValue() && nameAchievement.equals(entry.getKey())) {
                bind.componentAchievement.getBackground().setTint(itemView.getContext().getColor(R.color.blue_v4));
                break;
            }
        }
    }


}
