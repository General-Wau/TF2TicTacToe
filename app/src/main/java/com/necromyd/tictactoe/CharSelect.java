package com.necromyd.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CharSelect extends AppCompatActivity implements View.OnClickListener {

    private ImageView engie,demo,heavy,spy,medic,soldier,scout,sniper,pyro;
    private int s_engie,s_demo,s_heavy,s_spy,s_medic,s_soldier,s_scout,s_sniper,s_pyro,s_intro,s_begin;
    private TextView tv_player1, tv_player2;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private boolean selectionOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_select);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        engie = (ImageView) findViewById(R.id.iw_engie);
        demo = (ImageView) findViewById(R.id.iw_demoman);
        heavy = (ImageView) findViewById(R.id.iw_heavy);
        spy = (ImageView) findViewById(R.id.iw_spy);
        medic = (ImageView) findViewById(R.id.iw_medic);
        soldier = (ImageView) findViewById(R.id.iw_soldier);
        scout = (ImageView) findViewById(R.id.iw_scout);
        sniper = (ImageView) findViewById(R.id.iw_sniper);
        pyro = (ImageView) findViewById(R.id.iw_pyro);

        engie.setOnClickListener(this);
        demo.setOnClickListener(this);
        heavy.setOnClickListener(this);
        spy.setOnClickListener(this);
        medic.setOnClickListener(this);
        soldier.setOnClickListener(this);
        scout.setOnClickListener(this);
        sniper.setOnClickListener(this);
        pyro.setOnClickListener(this);

        tv_player1 = (TextView) findViewById(R.id.player1);
        tv_player2 = (TextView) findViewById(R.id.player2);

        s_engie = R.raw.engie_1;
        s_demo = R.raw.demo_2;
        s_heavy = R.raw.heavy_3;
        s_spy = R.raw.spy_2;
        s_medic = R.raw.medic_3;
        s_soldier = R.raw.soldier_2;
        s_scout = R.raw.scout_2;
        s_sniper = R.raw.sniper_2;
        s_pyro = R.raw.pyro_1;
        s_intro = R.raw.logo;
        s_begin = R.raw.begin;

        playSound("logo");

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iw_engie :
                if(!selectionOrder){
                    selectionOrder = true;
                    tv_player1.setText("P1 : Engineer");
                    playSound("engie");
                }else{
                    selectionOrder = false;
                    tv_player2.setText("Engineer : P2");
                    playSound("engie");
                    nextScreen();
                }
                break;
            case R.id.iw_demoman :
                if(!selectionOrder){
                    selectionOrder = true;
                    tv_player1.setText("P1 : Demoman");
                    playSound("demo");
                }else{
                    selectionOrder = false;
                    tv_player2.setText("Demoman : P2");
                    playSound("demo");
                    nextScreen();
                }
                break;
            case R.id.iw_heavy :
                if(!selectionOrder){
                    selectionOrder = true;
                    tv_player1.setText("P1 : Heavy");
                    playSound("heavy");
                }else{
                    selectionOrder = false;
                    tv_player2.setText("Heavy : P2");
                    playSound("heavy");
                    nextScreen();
                }
                break;
            case R.id.iw_spy :
                if(!selectionOrder){
                    selectionOrder = true;
                    tv_player1.setText("P1 : Spy");
                    playSound("spy");
                }else{
                    selectionOrder = false;
                    tv_player2.setText("Spy : P2");
                    playSound("spy");
                    nextScreen();
                }
                break;
            case R.id.iw_medic :
                if(!selectionOrder){
                    selectionOrder = true;
                    tv_player1.setText("P1 : Medic");
                    playSound("medic");
                }else{
                    selectionOrder = false;
                    tv_player2.setText("Medic : P2");
                    playSound("medic");
                    nextScreen();
                }
                break;
            case R.id.iw_soldier :
                if(!selectionOrder){
                    selectionOrder = true;
                    tv_player1.setText("P1 : Soldier");
                    playSound("soldier");
                }else{
                    selectionOrder = false;
                    tv_player2.setText("Soldier : P2");
                    playSound("soldier");
                    nextScreen();
                }
                break;
            case R.id.iw_scout :
                if(!selectionOrder){
                    selectionOrder = true;
                    tv_player1.setText("P1 : Scout");
                    playSound("scout");
                }else{
                    selectionOrder = false;
                    tv_player2.setText("Scout : P2");
                    playSound("scout");
                    nextScreen();
                }
                break;
            case R.id.iw_sniper :
                if(!selectionOrder){
                    selectionOrder = true;
                    tv_player1.setText("P1 : Sniper");
                    playSound("sniper");
                }else{
                    selectionOrder = false;
                    tv_player2.setText("Sniper : P2");
                    playSound("sniper");
                    nextScreen();
                }
                break;
            case R.id.iw_pyro :
                if(!selectionOrder){
                    selectionOrder = true;
                    tv_player1.setText("P1 : Pyro");
                    playSound("pyro");
                }else{
                    selectionOrder = false;
                    tv_player2.setText("Pyro : P2");
                    playSound("pyro");
                    nextScreen();
                }
                break;
        }
    }

    private void nextScreen ()  {

        Handler handler=new Handler();
        Runnable r= () -> {
            playSound("begin");

            Intent intent = new Intent(CharSelect.this, MainActivity.class);
            String player1 = tv_player1.getText().toString().replace("P1 : ", "");
            String player2 = tv_player2.getText().toString().replace(" : P2", "");
            intent.putExtra("player1", player1);
            intent.putExtra("player2", player2);
            startActivity(intent);
        };
        handler.postDelayed(r, 2200);

    }

    private void playSound (String sound){
        releaseMediaPlayer();
        int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            switch (sound) {
                case "logo":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_intro);
                    break;
                case "engie":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_engie);
                    break;
                case "demo":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_demo);
                    break;
                case "heavy":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_heavy);
                    break;
                case "spy":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_spy);
                    break;
                case "medic":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_medic);
                    break;
                case "soldier":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_soldier);
                    break;
                case "scout":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_scout);
                    break;
                case "sniper":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_sniper);
                    break;
                case "pyro":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_pyro);
                    break;
                case "begin":
                    mediaPlayer = MediaPlayer.create(CharSelect.this, s_begin);
                    break;
            }
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(completionListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };
    private final MediaPlayer.OnCompletionListener completionListener = mediaPlayer -> {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer();
    };


}
