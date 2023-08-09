package com.goat.habits.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goat.habits.databinding.ComponentHabitBinding;
import com.goat.habits.persistence.model.HabitModel;
import com.goat.habits.ui.listener.HabitListener;
import com.goat.habits.ui.viewholder.HabitViewHolder;

import java.util.ArrayList;
import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitViewHolder> {

    private List<HabitModel> habitList = new ArrayList<>();
    private HabitListener listener;

    @NonNull
    @Override
    //Faz a criação do layout para cada componente na lista
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ComponentHabitBinding itemView = ComponentHabitBinding.inflate(inflater, parent, false);

        return new HabitViewHolder(itemView, listener);
    }

    @Override
    //Conecta os elementos de interface com os dados
    public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
        holder.bindData(habitList.get(position));
    }

    @Override
    //Tamanho da lista
    public int getItemCount() {
        return habitList.size();
    }

    public void updateList(List<HabitModel> habitModelList) {
        habitList = habitModelList;
        notifyDataSetChanged();
    }

    public void setListener(HabitListener habitListener){
        this.listener = habitListener;
    }
}
