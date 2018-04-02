package com.aobri.omaccollection.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aobri.omaccollection.R;

import java.util.Locale;

public class AppMusicPlayerActivity extends AppCompatActivity {

    private Button playButton, pauseButton;
    private SeekBar mSeekBar;
    private TextView volumeTextView;
    private MediaPlayer mMediaPlayer;
    private int currentVolume = 60;
    private Handler mHandler = new Handler();

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(AppMusicPlayerActivity.this, "Done Playing!", Toast.LENGTH_SHORT).show();
            pauseButton.setEnabled(false);
            playButton.setEnabled(true);
        }
    };

    private Runnable seekBarUpdateRunnable = new Runnable() {
        @Override
        public void run() {
            if (mMediaPlayer != null) {
                int mCurrentPosition = mMediaPlayer.getCurrentPosition() / 1000;
                mSeekBar.setProgress(mCurrentPosition);
            }
            mHandler.postDelayed(this, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_music_player);
        setTitle(R.string.app_music_player_name);

        playButton = findViewById(R.id.play_button);
        pauseButton = findViewById(R.id.pause_button);
        FloatingActionButton volumeUpButton = findViewById(R.id.volume_up_button);
        FloatingActionButton volumeDownButton = findViewById(R.id.volume_down_button);
        volumeTextView = findViewById(R.id.volume_level_text_view);
        mSeekBar = findViewById(R.id.audio_seek_bar);
        findViewById(R.id.song_title_text_view).setSelected(true);

        mMediaPlayer = MediaPlayer.create(this, R.raw.narrowskies_iwantthewindtocarryme);
        mMediaPlayer.setLooping(false);
        setMediaPlayerVolume();
        mSeekBar.setMax(mMediaPlayer.getDuration() / 1000);
        pauseButton.setEnabled(false);

        runOnUiThread(seekBarUpdateRunnable);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.start();
                pauseButton.setEnabled(true);
                playButton.setEnabled(false);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.pause();
                pauseButton.setEnabled(false);
                playButton.setEnabled(true);
            }
        });

        volumeUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentVolume < 100) {
                    currentVolume += 5;
                    setMediaPlayerVolume();
                }
            }
        });

        volumeDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentVolume > 0) {
                    currentVolume -= 5;
                    setMediaPlayerVolume();
                }
            }
        });

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mMediaPlayer != null && fromUser) {
                    mMediaPlayer.seekTo(progress * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
    }

    /**
     * Sets the logarithmic volume scale of the media player and shows the value in a text view.
     */
    private void setMediaPlayerVolume() {
        int maximumVolume = 100;
        float logarithmicVolumeScale = 1 - ((float) (Math.log(maximumVolume - currentVolume) / Math.log(maximumVolume)));
        mMediaPlayer.setVolume(logarithmicVolumeScale, logarithmicVolumeScale);
        volumeTextView.setText(String.format(Locale.getDefault(), "%d", currentVolume));
    }

    @Override
    protected void onStop() {
        super.onStop();
        pauseButton.setEnabled(false);
        playButton.setEnabled(true);
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}