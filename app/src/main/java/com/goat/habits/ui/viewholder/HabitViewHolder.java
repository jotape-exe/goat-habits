package com.goat.habits.ui.viewholder;

import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.goat.habits.databinding.ComponentHabitBinding;
import com.goat.habits.persistence.model.HabitModel;
import com.goat.habits.preferences.UserPreferences;
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
    public void bindData(HabitModel habit) {
        bind.checkDone.setChecked(false);
        bind.textTitle.setText(habit.getName());
        bind.textFrequencyComponent.setText(habit.getFrequency());
        bind.textStartDate.setText(habit.getStartDate());

        bind.componentHabit.setOnLongClickListener(v -> {
            listener.onLongClick(habit.getId());
            Toast.makeText(itemView.getContext(), "Segurou!", Toast.LENGTH_LONG).show();
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

        bind.checkDone.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                listener.onSelectCheckBox();
                listener.onDelete(habit.getId());
                Toast.makeText(itemView.getContext(), "Hábito concluído!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
