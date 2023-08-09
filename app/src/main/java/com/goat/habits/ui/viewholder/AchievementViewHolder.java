package com.goat.habits.ui.viewholder;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goat.habits.R;
import com.goat.habits.databinding.ComponentAchievementBinding;
import com.goat.habits.persistence.model.AchievementModel;

public class AchievementViewHolder extends RecyclerView.ViewHolder {

    private  ComponentAchievementBinding bind;

    public AchievementViewHolder(@NonNull  ComponentAchievementBinding bind) {
        super(bind.getRoot());
        this.bind = bind;
    }

    public void bindData(AchievementModel achievement){
        bind.textTitleAchievement.setText(achievement.getName());
        bind.textDescriptionAchievement.setText(achievement.getDescription());
        bind.textTagAchievement.setText(achievement.getType());

        changeRarity(achievement.getType());

    }

    private void changeRarity(String type) {
        Log.d("ChangeRarity", "Changing rarity for type: " + type);
        switch (type){
            case "Raro":
                Log.d("ChangeRarity", "Setting background color to blue");
                bind.containerRarityText.getBackground().setTint(itemView.getContext().getColor(R.color.blue_v2));
                break;
            case "Épico":
                Log.d("ChangeRarity", "Setting background color to purple");
                bind.containerRarityText.getBackground().setTint(itemView.getContext().getColor(R.color.purple_v1));
                break;
            case "Monstro":
                Log.d("ChangeRarity", "Setting background color to yellow");
                bind.containerRarityText.getBackground().setTint(itemView.getContext().getColor(R.color.yellow));
                bind.textTagAchievement.setTextColor(itemView.getContext().getColor(R.color.black));
                break;
        }
    }

}
