package com.necromyd.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random;
    private ImageView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private String startGame = "X";
    private int b1 = 5, b2 = 5, b3 = 5, b4 = 5, b5 = 5, b6 = 5, b7 = 5, b8 = 5, b9 = 5, xCount = 0, oCount = 0, i = 0;
    private int demo_1, demo_2, demo_3, demo_win,
            engie_1, engie_2, engie_3, engie_win,
            heavy_1, heavy_2, heavy_3, heavy_win,
            medic_1, medic_2, medic_3, medic_win,
            spy_1, spy_2, spy_3, spy_win,
            soldier_1, soldier_2, soldier_3, soldier_win,
            pyro_1, pyro_2, pyro_3, pyro_win,
            sniper_1, sniper_2, sniper_3, sniper_win,
            scout_1, scout_2, scout_3, scout_win;
    private int p1Image, p2Image;
    private TextView scoreX, scoreO, nextPlayer;
    private String player1, player2;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        releaseMediaPlayer();

        random = new Random(123456789);

        btn1 = findViewById(R.id.buttonImage1);
        btn2 = findViewById(R.id.buttonImage2);
        btn3 = findViewById(R.id.buttonImage3);
        btn4 = findViewById(R.id.buttonImage4);
        btn5 = findViewById(R.id.buttonImage5);
        btn6 = findViewById(R.id.buttonImage6);
        btn7 = findViewById(R.id.buttonImage7);
        btn8 = findViewById(R.id.buttonImage8);
        btn9 = findViewById(R.id.buttonImage9);

        Intent intent = getIntent();
        player1 = intent.getStringExtra("player1");
        player2 = intent.getStringExtra("player2");

        nextPlayer = findViewById(R.id.tv_nextPlayer);
        nextPlayer.setText(player1 + " is next !");
        scoreX = findViewById(R.id.ScoreX);
        scoreO = findViewById(R.id.ScoreY);
        scoreX.setText(player1 + " : 0");
        scoreO.setText(player2 + " : 0");

        engie_1 = R.raw.engie_1;
        engie_2 = R.raw.engie_2;
        engie_3 = R.raw.engie_3;
        engie_win = R.raw.engie_win;
        spy_1 = R.raw.spy_1;
        spy_2 = R.raw.spy_2;
        spy_3 = R.raw.spy_3;
        spy_win = R.raw.spy_win;
        scout_1 = R.raw.scout_1;
        scout_2 = R.raw.scout_2;
        scout_3 = R.raw.scout_3;
        scout_win = R.raw.scout_win;
        sniper_1 = R.raw.sniper_1;
        sniper_2 = R.raw.sniper_2;
        sniper_3 = R.raw.sniper_3;
        sniper_win = R.raw.sniper_win;
        heavy_1 = R.raw.heavy_1;
        heavy_2 = R.raw.heavy_2;
        heavy_3 = R.raw.heavy_3;
        heavy_win = R.raw.heavy_win;
        medic_1 = R.raw.medic_1;
        medic_2 = R.raw.medic_2;
        medic_3 = R.raw.medic_3;
        medic_win = R.raw.medic_win;
        pyro_1 = R.raw.pyro_1;
        pyro_2 = R.raw.pyro_2;
        pyro_3 = R.raw.pyro_3;
        pyro_win = R.raw.pyro_win;
        soldier_1 = R.raw.soldier_1;
        soldier_2 = R.raw.soldier_2;
        soldier_3 = R.raw.soldier_3;
        soldier_win = R.raw.soldier_win;
        demo_1 = R.raw.demo_1;
        demo_2 = R.raw.demo_2;
        demo_3 = R.raw.demo_3;
        demo_win = R.raw.demo_win;

        Button reset = findViewById(R.id.reset);

        reset.setOnClickListener(v -> {
            btn1.setImageDrawable(null);
            btn2.setImageDrawable(null);
            btn3.setImageDrawable(null);
            btn4.setImageDrawable(null);
            btn5.setImageDrawable(null);
            btn6.setImageDrawable(null);
            btn7.setImageDrawable(null);
            btn8.setImageDrawable(null);
            btn9.setImageDrawable(null);
            resetValues();
            xCount = 0;
            oCount = 0;
            scoreX.setText(player1 + " : " + xCount);
            scoreO.setText(player2 + " : " + oCount);

            Intent intent1 = new Intent(MainActivity.this, CharSelect.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent1);
        });

        btn1.setOnClickListener(v -> {
            if (startGame.equals("X")) {
                setup(btn1, player1);
                b1 = 1;
                i++;
            } else {
                setup(btn1, player2);
                b1 = 0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn2.setOnClickListener(v -> {
            if (startGame.equals("X")) {
                setup(btn2, player1);
                b2 = 1;
                i++;
            } else {
                setup(btn2, player2);
                b2 = 0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn3.setOnClickListener(v -> {
            if (startGame.equals("X")) {
                setup(btn3, player1);
                b3 = 1;
                i++;
            } else {
                setup(btn3, player2);
                b3 = 0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn4.setOnClickListener(v -> {
            if (startGame.equals("X")) {
                setup(btn4, player1);
                b4 = 1;
                i++;
            } else {
                setup(btn4, player2);
                b4 = 0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn5.setOnClickListener(v -> {
            if (startGame.equals("X")) {
                setup(btn5, player1);
                b5 = 1;
                i++;
            } else {
                setup(btn5, player2);
                b5 = 0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn6.setOnClickListener(v -> {
            if (startGame.equals("X")) {
                setup(btn6, player1);
                b6 = 1;
                i++;
            } else {
                setup(btn6, player2);
                b6 = 0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn7.setOnClickListener(v -> {
            if (startGame.equals("X")) {
                setup(btn7, player1);
                b7 = 1;
                i++;
            } else {
                setup(btn7, player2);
                b7 = 0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn8.setOnClickListener(v -> {
            if (startGame.equals("X")) {
                setup(btn8, player1);
                b8 = 1;
                i++;
            } else {
                setup(btn8, player2);
                b8 = 0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn9.setOnClickListener(v -> {
            if (startGame.equals("X")) {
                setup(btn9, player1);
                b9 = 1;
                i++;
            } else {
                setup(btn9, player2);
                b9 = 0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

    }

    private void setup(ImageView i, String s) {
        int num = random.nextInt(3) + 1;
        releaseMediaPlayer();

        int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            switch (s) {
                case "Engineer":
                    i.setImageResource(R.drawable.sentry);
                    switch (num) {
                        case 1:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, engie_1);
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, engie_2);
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, engie_3);
                            break;
                    }
                    break;
                case "Demoman":
                    i.setImageResource(R.drawable.bottle);
                    switch (num) {
                        case 1:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, demo_1);
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, demo_2);
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, demo_3);
                            break;
                    }
                    break;
                case "Heavy":
                    i.setImageResource(R.drawable.sandwitch);
                    switch (num) {
                        case 1:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, heavy_1);
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, heavy_2);
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, heavy_3);
                            break;
                    }
                    break;
                case "Spy":
                    i.setImageResource(R.drawable.mask);
                    switch (num) {
                        case 1:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, spy_1);
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, spy_2);
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, spy_3);
                            break;
                    }
                    break;
                case "Medic":
                    i.setImageResource(R.drawable.syringe);
                    switch (num) {
                        case 1:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, medic_1);
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, medic_2);
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, medic_3);
                            break;
                    }
                    break;
                case "Soldier":
                    i.setImageResource(R.drawable.shovel);
                    switch (num) {
                        case 1:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, soldier_1);
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, soldier_2);
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, soldier_3);
                            break;
                    }
                    break;
                case "Scout":
                    i.setImageResource(R.drawable.bonk);
                    switch (num) {
                        case 1:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, scout_1);
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, scout_2);
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, scout_3);
                            break;
                    }
                    break;
                case "Sniper":
                    i.setImageResource(R.drawable.knife);
                    switch (num) {
                        case 1:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, sniper_1);
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, sniper_2);
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, sniper_3);
                            break;
                    }
                    break;
                case "Pyro":
                    i.setImageResource(R.drawable.goggles);
                    switch (num) {
                        case 1:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, pyro_1);
                            break;
                        case 2:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, pyro_2);
                            break;
                        case 3:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, pyro_3);
                            break;
                    }
                    break;
            }
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(completionListener);
        }
    }

    private void choosePlayer() {

        if (startGame.equals("X")) {
            startGame = "O";
            nextPlayer.setText(player2 + " is next !");
        } else {
            startGame = "X";
            nextPlayer.setText(player1 + " is next !");
        }
    }

    private void winingGame() {
        if ((b1 == 1) && (b2 == 1) && (b3 == 1)) {
            playSound(player1);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + " Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(player1 + " : " + xCount);
        } else if ((b4 == 1) && (b5 == 1) && (b6 == 1)) {
            playSound(player1);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(player1 + " : " + xCount);
        } else if ((b7 == 1) && (b8 == 1) && (b9 == 1)) {
            playSound(player1);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(player1 + " : " + xCount);
        } else if ((b1 == 1) && (b4 == 1) && (b7 == 1)) {
            playSound(player1);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(player1 + " : " + xCount);
        } else if ((b2 == 1) && (b5 == 1) && (b8 == 1)) {
            playSound(player1);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(player1 + " : " + xCount);
        } else if ((b3 == 1) && (b6 == 1) && (b9 == 1)) {
            playSound(player1);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(player1 + " : " + xCount);
        } else if ((b1 == 1) && (b5 == 1) && (b9 == 1)) {
            playSound(player1);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(player1 + " : " + xCount);
        } else if ((b3 == 1) && (b5 == 1) && (b7 == 1)) {
            playSound(player1);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(player1 + " : " + xCount);
        } else if ((b1 == 0) && (b2 == 0) && (b3 == 0)) {
            playSound(player2);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(player2 + " : " + oCount);
        } else if ((b4 == 0) && (b5 == 0) && (b6 == 0)) {
            playSound(player2);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(player2 + " : " + oCount);
        } else if ((b7 == 0) && (b8 == 0) && (b9 == 0)) {
            playSound(player2);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(player2 + " : " + oCount);
        } else if ((b1 == 0) && (b4 == 0) && (b7 == 0)) {
            playSound(player2);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(player2 + " : " + oCount);
        } else if ((b2 == 0) && (b5 == 0) && (b8 == 0)) {
            playSound(player2);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(player2 + " : " + oCount);
        } else if ((b3 == 0) && (b6 == 0) && (b9 == 0)) {
            playSound(player2);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(player2 + " : " + oCount);
        } else if ((b1 == 0) && (b5 == 0) && (b9 == 0)) {
            playSound(player2);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(player2 + " : " + oCount);
        } else if ((b3 == 0) && (b5 == 0) && (b7 == 0)) {
            playSound(player2);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2 + "  Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(player2 + " : " + oCount);
        } else {
            if (i == 9) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Nobody Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn1.setImageDrawable(null);
                        btn2.setImageDrawable(null);
                        btn3.setImageDrawable(null);
                        btn4.setImageDrawable(null);
                        btn5.setImageDrawable(null);
                        btn6.setImageDrawable(null);
                        btn7.setImageDrawable(null);
                        btn8.setImageDrawable(null);
                        btn9.setImageDrawable(null);
                        resetValues();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }

    }

    private void resetValues() {
        b1 = 5;
        b2 = 5;
        b3 = 5;
        b4 = 5;
        b5 = 5;
        b6 = 5;
        b7 = 5;
        b8 = 5;
        b9 = 5;
        i = 0;
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    private final MediaPlayer.OnCompletionListener completionListener = mediaPlayer -> {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer();
    };

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

    private void playSound(String player) {
        releaseMediaPlayer();
        int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            switch (player) {
                case "Engineer":
                    mediaPlayer = MediaPlayer.create(MainActivity.this, engie_win);
                    break;
                case "Demoman":
                    mediaPlayer = MediaPlayer.create(MainActivity.this, demo_win);
                    break;
                case "Heavy":
                    mediaPlayer = MediaPlayer.create(MainActivity.this, heavy_win);
                    break;
                case "Spy":
                    mediaPlayer = MediaPlayer.create(MainActivity.this, spy_win);
                    break;
                case "Medic":
                    mediaPlayer = MediaPlayer.create(MainActivity.this, medic_win);
                    break;
                case "Soldier":
                    mediaPlayer = MediaPlayer.create(MainActivity.this, soldier_win);
                    break;
                case "Scout":
                    mediaPlayer = MediaPlayer.create(MainActivity.this, scout_win);
                    break;
                case "Sniper":
                    mediaPlayer = MediaPlayer.create(MainActivity.this, sniper_win);
                    break;
                case "Pyro":
                    mediaPlayer = MediaPlayer.create(MainActivity.this, pyro_win);
                    break;
            }
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(completionListener);
        }
    }
}