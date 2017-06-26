package com.example.wanglin.a10music;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer md;

    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void play(View v) {

        if (md == null) {
            md = MediaPlayer.create(MainActivity.this, R.raw.a);

        } else if (md.isPlaying()) {
            return;

        } else {
            currentPosition = md.getCurrentPosition();
        }
        md.start();

    }

    public void pause(View v) {

        if (md == null) {

            return;
        } else if (md.isPlaying()) {

            currentPosition = md.getCurrentPosition();

            md.pause();

        } else {



            return;
        }
    }

    public void stop(View v) {
        stop();
    }


    private void stop() {
        if (md != null) {
            currentPosition = 0;
            md.stop();
            md = null;
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop();
    }
}
