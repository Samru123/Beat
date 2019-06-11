package com.example.beat;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer1;
    SoundPool soundPool;
    int explode = 0;
    Random crazy=new Random();
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
         v = new View(this);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        v.setOnTouchListener(this);
        setContentView(v);
        mediaPlayer = MediaPlayer.create(this, R.raw.backgroundmusic);
        mediaPlayer.start();
        mediaPlayer1=MediaPlayer.create(this,R.raw.soundtrack);
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        explode=soundPool.load(this,R.raw.explosion,1);
        v.setBackgroundColor(Color.rgb(crazy.nextInt(255),crazy.nextInt(255),crazy.nextInt(255)));
    }

    @Override
    public void onClick(View view) {
        if(explode!=0)
        {
            soundPool.play(explode,1,1,0,0,1);
        }

    }

    @Override
    public boolean onLongClick(View view) {
        mediaPlayer.stop();
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mediaPlayer1.start();
        v.setBackgroundColor(Color.rgb(crazy.nextInt(255),crazy.nextInt(255),crazy.nextInt(255)));
        return true;
    }
}
