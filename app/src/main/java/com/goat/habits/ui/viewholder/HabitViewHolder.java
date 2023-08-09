package com.goat.habits.ui.viewholder;

import android.content.DialogInterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.goat.habits.databinding.ComponentHabitBinding;
import com.goat.habits.persistence.model.HabitModel;
import com.goat.habits.ui.listener.HabitListener;

public class HabitViewHolder extends RecyclerView.ViewHolder {

    private ComponentHabitBinding bind;
    private HabitListener listener;

    public HabitViewHolder(@NonNull ComponentHabitBinding bind, HabitListener listener) {
        super(bind.getRoot());
        this.bind = bind;
        this.listener = listener;
    }

    //Recebe o obj e seta nos campos do componente
    public void bindData(HabitModel habit){
        bind.textTitle.setText(habit.getName());
        bind.textFrequencyComponent.setText(habit.getFrequency());
        bind.textStartDate.setText(habit.getStartDate());

        bind.componentHabit.setOnLongClickListener(v -> {
            listener.onLongClick(habit.getId());
            return true;
        });

        bind.imageButtonDelete.setOnClickListener(view -> {
            new AlertDialog.Builder(itemView.getContext())
                    .setTitle("Excluir Hábito")
                    .setMessage("Vai quebrar sua rotina mesmo? :(")
                    .setNeutralButton("CANCELAR", null)
                    .setPositiveButton("SIM", (dialog, which) -> {
                        listener.onDelete(habit.getId());
                    })
                    .setNegativeButton("NÃO", null)
                    .create()
                    .show();
        });

    }
}
