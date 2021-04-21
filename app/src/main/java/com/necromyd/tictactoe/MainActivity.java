package com.necromyd.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private String startGame = "X";
    private int b1=5, b2=5, b3=5, b4=5, b5=5, b6=5, b7=5, b8=5, b9=5, xCount=0, oCount=0, i=0;
    private TextView scoreX, scoreO;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.buttonImage1);
        btn2 = findViewById(R.id.buttonImage2);
        btn3 = findViewById(R.id.buttonImage3);
        btn4 = findViewById(R.id.buttonImage4);
        btn5 = findViewById(R.id.buttonImage5);
        btn6 = findViewById(R.id.buttonImage6);
        btn7 = findViewById(R.id.buttonImage7);
        btn8 = findViewById(R.id.buttonImage8);
        btn9 = findViewById(R.id.buttonImage9);

        scoreX = findViewById(R.id.ScoreX);
        scoreO = findViewById(R.id.ScoreY);

        reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                scoreX.setText("Score X :- " +String.valueOf(xCount));
                scoreO.setText("Score O :- " +String.valueOf(oCount));
            }
        });

        btn1.setOnClickListener(v -> {
            if (startGame.equals("X")){
                btn1.setImageResource(R.drawable.cross);
                b1=1;
                i++;
            }else{
                btn1.setImageResource(R.drawable.circle);
                b1=0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn2.setOnClickListener(v -> {
            if (startGame.equals("X")){
                btn2.setImageResource(R.drawable.cross);
                b2=1;
                i++;
            }else{
                btn2.setImageResource(R.drawable.circle);
                b2=0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn3.setOnClickListener(v -> {
            if (startGame.equals("X")){
                btn3.setImageResource(R.drawable.cross);
                b3=1;
                i++;
            }else{
                btn3.setImageResource(R.drawable.circle);
                b3=0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn4.setOnClickListener(v -> {
            if (startGame.equals("X")){
                btn4.setImageResource(R.drawable.cross);
                b4=1;
                i++;
            }else{
                btn4.setImageResource(R.drawable.circle);
                b4=0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn5.setOnClickListener(v -> {
            if (startGame.equals("X")){
                btn5.setImageResource(R.drawable.cross);
                b5=1;
                i++;
            }else{
                btn5.setImageResource(R.drawable.circle);
                b5=0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn6.setOnClickListener(v -> {
            if (startGame.equals("X")){
                btn6.setImageResource(R.drawable.cross);
                b6=1;
                i++;
            }else{
                btn6.setImageResource(R.drawable.circle);
                b6=0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn7.setOnClickListener(v -> {
            if (startGame.equals("X")){
                btn7.setImageResource(R.drawable.cross);
                b7=1;
                i++;
            }else{
                btn7.setImageResource(R.drawable.circle);
                b7=0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn8.setOnClickListener(v -> {
            if (startGame.equals("X")){
                btn8.setImageResource(R.drawable.cross);
                b8=1;
                i++;
            }else{
                btn8.setImageResource(R.drawable.circle);
                b8=0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

        btn9.setOnClickListener(v -> {
            if (startGame.equals("X")){
                btn9.setImageResource(R.drawable.cross);
                b9=1;
                i++;
            }else{
                btn9.setImageResource(R.drawable.circle);
                b9=0;
                i++;
            }
            choosePlayer();
            winingGame();
        });

    }

    private void choosePlayer(){

        if(startGame.equals("X")){
            startGame = "O";
        }else{
            startGame = "X";
        }
    }

    private void winingGame(){
        if((b1==1) && (b2==1) && (b3==1)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreX.setText("Score X :- " +String.valueOf(xCount));
        }else if((b4==1) && (b5==1) && (b6==1)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreX.setText("Score X :- " +String.valueOf(xCount));
        }else if((b7==1) && (b8==1) && (b9==1)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreX.setText("Score X :- " +String.valueOf(xCount));
        }else if((b1==1) && (b4==1) && (b7==1)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreX.setText("Score X :- " +String.valueOf(xCount));
        }else if((b2==1) && (b5==1) && (b8==1)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreX.setText("Score X :- " +String.valueOf(xCount));
        }else if((b3==1) && (b6==1) && (b9==1)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreX.setText("Score X :- " +String.valueOf(xCount));
        }else if((b1==1) && (b5==1) && (b9==1)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreX.setText("Score X :- " +String.valueOf(xCount));
        }else if((b3==1) && (b5==1) && (b7==1)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreX.setText("Score X :- " +String.valueOf(xCount));
        }else if((b1==0) && (b2==0) && (b3==0)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player O Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreO.setText("Score O :- " +String.valueOf(oCount));
        }else if((b4==0) && (b5==0) && (b6==0)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player O Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreO.setText("Score O :- " +String.valueOf(oCount));
        }else if((b7==0) && (b8==0) && (b9==0)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player O Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreO.setText("Score O :- " +String.valueOf(oCount));
        }else if((b1==0) && (b4==0) && (b7==0)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player O Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreO.setText("Score O :- " +String.valueOf(oCount));
        }else if((b2==0) && (b5==0) && (b8==0)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player O Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreO.setText("Score O :- " +String.valueOf(oCount));
        }else if((b3==0) && (b6==0) && (b9==0)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player O Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreO.setText("Score O :- " +String.valueOf(oCount));
        }else if((b1==0) && (b5==0) && (b9==0)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player O Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreO.setText("Score O :- " +String.valueOf(oCount));
        }else if((b3==0) && (b5==0) && (b7==0)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player O Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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
            scoreO.setText("Score O :- " +String.valueOf(oCount));
        }else{
            if(i == 9){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Nobody Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener(){
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

    private void resetValues(){
        b1=5;
        b2=5;
        b3=5;
        b4=5;
        b5=5;
        b6=5;
        b7=5;
        b8=5;
        b9=5;
        i=0;
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}