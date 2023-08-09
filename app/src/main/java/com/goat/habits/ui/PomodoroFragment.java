package com.goat.habits.ui;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.goat.habits.R;
import com.goat.habits.databinding.FragmentPomodoroBinding;

public class PomodoroFragment extends Fragment {

    private Long limit = 25L;
    private Long pauseOffSet = 0L;
    private Boolean isPlaying = false;
    private CountDownTimer countDownTimer;
    FragmentPomodoroBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPomodoroBinding.inflate(inflater, container, false);

        binding.toggleOnOf.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (!isPlaying) {
                    // 25 minutos em milissegundos - Tempo do ciclo
                    startTimer(limit * 60 * 1000);
                }
            } else {
                stopTimer();
            }
        });

        binding.buttonStop.setOnClickListener(view -> {
            if (isPlaying){
                binding.chronometer.setBase(SystemClock.elapsedRealtime());
                pauseOffSet = 0L;
                binding.chronometer.start();
                isPlaying = true;
            }
        });

        return binding.getRoot();
    }

    private void startTimer(long millisInFuture) {
        countDownTimer = new CountDownTimer(millisInFuture, 1000) {
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                // Limite alcançado, tocar o som e reiniciar o cronômetro
                playNotificationSound();
                binding.chronometer.setBase(SystemClock.elapsedRealtime());
                binding.chronometer.stop();
                pauseOffSet = 0L;
            }

        }.start();

        binding.chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
        binding.chronometer.start();
        isPlaying = true;
    }

    private void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }

        binding.chronometer.stop();
        pauseOffSet = SystemClock.elapsedRealtime() - binding.chronometer.getBase();
        isPlaying = false;
    }

    private void playNotificationSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(requireContext(), R.raw.cabrito); // Substitua pelo nome do seu arquivo de som

        mediaPlayer.setOnCompletionListener(mp -> {
            mediaPlayer.release();
        });

        mediaPlayer.start();
    }

}