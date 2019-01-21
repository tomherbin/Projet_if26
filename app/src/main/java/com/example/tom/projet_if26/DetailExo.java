package com.example.tom.projet_if26;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class DetailExo extends AppCompatActivity implements Serializable {
    private static final long START_TIME_IN_MILLIS =90000;
    private ImageView img;
    private TextView desc;
    private TextView timer;
    private ImageButton reset;
    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long mtimeleft = START_TIME_IN_MILLIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_entrainement);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        intent.getSerializableExtra("exo");
        reset=this.findViewById(R.id.reset);
        timer=this.findViewById(R.id.timer);
        desc=this.findViewById(R.id.tvdesc);

        img = this.findViewById(R.id.img);
        Bundle b = getIntent().getExtras();
        Exercice ex = b.getParcelable("exo");
        AssetManager assetManager = getAssets();
        try {
            InputStream ims = assetManager.open(ex.getTitre()+".png");
            Drawable d = Drawable.createFromStream(ims, null);
            img.setImageDrawable(d);
        } catch (IOException e) {
            return;
        }
        getSupportActionBar().setTitle(ex.getTitre());

        desc.setText(ex.getDesc()+"\n \n \n Nombre de séries: "+ex.getSerie()+"\n Nombre de répétitions: "+ex.getReps());
    }

    public void start(View v){
        if(timerRunning){
            pauseTimer();
        }else {
            startTimer();
        }
    }
    public void resetTimer(View v){
        reset();
    }
    private void startTimer(){
        countDownTimer = new CountDownTimer(mtimeleft,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                    mtimeleft= millisUntilFinished;
                    updateCountDownText();

            }

            @Override
            public void onFinish() {
                timerRunning = false;
                reset.setClickable(true);
            }
        }.start();
        timerRunning = true;
        reset.setClickable(false);

    }
    private void updateCountDownText(){
        int minutes = (int) (mtimeleft/1000) /60;
        int seconds = (int) (mtimeleft/1000)%60;
        String timeleft = String.format("%02d:%02d",minutes,seconds);
        timer.setText(timeleft);
    }
    private void reset(){
        mtimeleft=START_TIME_IN_MILLIS;
        updateCountDownText();

    }
    public void pauseTimer(){
        countDownTimer.cancel();
        timerRunning=false;
        reset.setClickable(true);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
