package com.goat.habits.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goat.habits.databinding.ComponentAchievementBinding;
import com.goat.habits.persistence.model.AchievementModel;
import com.goat.habits.ui.viewholder.AchievementViewHolder;

import java.util.ArrayList;
import java.util.List;

public class AchievementAdapter extends RecyclerView.Adapter<AchievementViewHolder> {

    private List<AchievementModel> achievementList = new ArrayList<>();

    @NonNull
    @Override
    public AchievementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ComponentAchievementBinding itemView = ComponentAchievementBinding.inflate(inflater, parent, false);

        return new AchievementViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementViewHolder holder, int position) {
        holder.bindData(achievementList.get(position));
    }

    @Override
    public int getItemCount() {
        return achievementList.size();
    }

    public void updateList(List<AchievementModel> achievementModelList) {
        achievementList = achievementModelList;
        notifyDataSetChanged();
    }
}
