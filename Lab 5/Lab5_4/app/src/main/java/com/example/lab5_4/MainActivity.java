package com.example.lab5_4;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer music;
    private SeekBar seekBar;
    private PlayMedia playMedia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(this, R.raw.audio);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(music.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Xử lý khi giá trị của SeekBar thay đổi
                // progress là giá trị hiện tại của SeekBar
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Xử lý khi người dùng bắt đầu chạm vào SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int seelkBarPostition=seekBar.getProgress();
                music.seekTo(seelkBarPostition);
            }
        });
    }

    @SuppressWarnings("deprecation")
    public void musicplay(View v) {
        music.start();
        playMedia = new PlayMedia();
        playMedia.execute();
    }

    // Pausing the music
    @SuppressWarnings("deprecation")
    public void musicpause(View v) {
        music.pause();
        if (playMedia != null) {
            playMedia.cancel(true);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (playMedia != null) {
            playMedia.cancel(true);
        }
        music.release();
        music = null;
    }

    @SuppressWarnings("deprecation")
    private class PlayMedia extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while (music != null && music.isPlaying()) {
                try {
                    int currentPosition = music.getCurrentPosition();
                    publishProgress(currentPosition);
                    Thread.sleep(500); // Update SeekBar every second
                } catch (InterruptedException e) {
                    Log.e("Lỗi", String.valueOf(e));
                    break;
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int progress = values[0];
            seekBar.setProgress(progress);
        }
    }
}