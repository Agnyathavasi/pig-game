package com.vishwajith.piggame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView pl1dot,pl2dot,pl1dice,pl2dice;
    TextView pl1score,pl2score,pl1current,pl2current;
    LinearLayout pl1roll,pl2roll,pl1hold,pl2hold,pl1back,pl2back;
    int score1=0,score2=0,current1=0,current2=0,dice1sc;
    boolean player1;
    TextView pl1name,pl2name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pl1dice = findViewById(R.id.player1dice);
        pl2dice = findViewById(R.id.player2dice);
        pl1dot = findViewById(R.id.player1dot);
        pl2dot = findViewById(R.id.player2dot);
        pl1score = findViewById(R.id.player1score);
        pl2score = findViewById(R.id.player2score);
        pl1current = findViewById(R.id.player1current);
        pl2current = findViewById(R.id.player2current);
        pl1roll = findViewById(R.id.player1roll);
        pl2roll = findViewById(R.id.player2roll);
        pl1hold = findViewById(R.id.player1hold);
        pl2hold = findViewById(R.id.player2hold);
        pl1back = findViewById(R.id.player1background);
        pl2back = findViewById(R.id.player2background);
        pl1name = findViewById(R.id.player1name);
        pl2name = findViewById(R.id.player2name);

        player1 = true;
        pl1dot.setVisibility(View.VISIBLE);
        pl2dot.setVisibility(View.INVISIBLE);
        pl1back.setBackgroundColor(Color.rgb(240,240,240));
        pl2back.setBackgroundColor(Color.rgb(255,255,255));
        pl2hold.setVisibility(View.INVISIBLE);
        pl1hold.setVisibility(View.VISIBLE);
        pl1roll.setVisibility(View.VISIBLE);
        pl2roll.setVisibility(View.INVISIBLE);

        pl1roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice1sc = (int)(Math.random() * (6 - 1 + 1) + 1);

                if (dice1sc==2){
                    pl1dice.setImageResource(R.drawable.dice2);
                }else if (dice1sc==3){
                    pl1dice.setImageResource(R.drawable.dice3);
                }else if (dice1sc==4){
                    pl1dice.setImageResource(R.drawable.dice4);
                }else if (dice1sc==5){
                    pl1dice.setImageResource(R.drawable.dice5);
                }else if (dice1sc==6){
                    pl1dice.setImageResource(R.drawable.dice6);
                }else if (dice1sc==1){
                    pl1dice.setImageResource(R.drawable.dice1);
                }

                if (dice1sc != 1) {
                    current1 = current1 + dice1sc;
                    pl1current.setText(Integer.toString(current1));
                }
                else
                {
                    current1 = 0;
                    pl1current.setText(Integer.toString(current1));
                    player1 = false;
                    pl2dot.setVisibility(View.VISIBLE);
                    pl1dot.setVisibility(View.INVISIBLE);
                    pl2back.setBackgroundColor(Color.rgb(240,240,240));
                    pl1back.setBackgroundColor(Color.rgb(255,255,255));
                    pl1hold.setVisibility(View.INVISIBLE);
                    pl2hold.setVisibility(View.VISIBLE);
                    pl2roll.setVisibility(View.VISIBLE);
                    pl1roll.setVisibility(View.INVISIBLE);

                }
            }
        });

        pl1hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score1 = score1 + current1;
                pl1score.setText(Integer.toString(score1));
                current1 = 0;
                pl1current.setText(Integer.toString(current1));
                player1 = false;
                pl2dot.setVisibility(View.VISIBLE);
                pl1dot.setVisibility(View.INVISIBLE);
                pl2back.setBackgroundColor(Color.rgb(240,240,240));
                pl1back.setBackgroundColor(Color.rgb(255,255,255));
                pl1hold.setVisibility(View.INVISIBLE);
                pl2hold.setVisibility(View.VISIBLE);
                pl2roll.setVisibility(View.VISIBLE);
                pl1roll.setVisibility(View.INVISIBLE);
                checkforwin();
                pl1dice.setImageResource(R.drawable.dice1);
            }
        });

        pl2roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice1sc = (int)(Math.random() * (6 - 1 + 1) + 1);

                if (dice1sc==2){
                    pl2dice.setImageResource(R.drawable.dice2);
                }else if (dice1sc==3){
                    pl2dice.setImageResource(R.drawable.dice3);
                }else if (dice1sc==4){
                    pl2dice.setImageResource(R.drawable.dice4);
                }else if (dice1sc==5){
                    pl2dice.setImageResource(R.drawable.dice5);
                }else if (dice1sc==6){
                    pl2dice.setImageResource(R.drawable.dice6);
                }else if (dice1sc==1){
                    pl2dice.setImageResource(R.drawable.dice1);
                }

                if (dice1sc != 1) {
                    current2 = current2 + dice1sc;
                    pl2current.setText(Integer.toString(current2));
                }
                else {
                    current2 = 0;
                    pl2current.setText(Integer.toString(current2));
                    player1 = true;
                    pl1dot.setVisibility(View.VISIBLE);
                    pl2dot.setVisibility(View.INVISIBLE);
                    pl1back.setBackgroundColor(Color.rgb(240,240,240));
                    pl2back.setBackgroundColor(Color.rgb(255,255,255));
                    pl2hold.setVisibility(View.INVISIBLE);
                    pl1hold.setVisibility(View.VISIBLE);
                    pl1roll.setVisibility(View.VISIBLE);
                    pl2roll.setVisibility(View.INVISIBLE);
                }
            }
        });

        pl2hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score2 = score2 + current2;
                current2 = 0;
                pl2current.setText(Integer.toString(current2));
                pl2score.setText(Integer.toString(score2));
                player1 = true;
                pl1dot.setVisibility(View.VISIBLE);
                pl2dot.setVisibility(View.INVISIBLE);
                pl1back.setBackgroundColor(Color.rgb(240,240,240));
                pl2back.setBackgroundColor(Color.rgb(255,255,255));
                pl2hold.setVisibility(View.INVISIBLE);
                pl1hold.setVisibility(View.VISIBLE);
                pl1roll.setVisibility(View.VISIBLE);
                pl2roll.setVisibility(View.INVISIBLE);
                checkforwin();
                pl2dice.setImageResource(R.drawable.dice1);
            }
        });

    }

    void checkforwin(){
        if (score1 >= 100){
            pl1dot.setVisibility(View.INVISIBLE);
            pl2dot.setVisibility(View.INVISIBLE);
            pl1hold.setVisibility(View.INVISIBLE);
            pl2hold.setVisibility(View.INVISIBLE);
            pl1roll.setVisibility(View.INVISIBLE);
            pl2roll.setVisibility(View.INVISIBLE);
            pl1dice.setVisibility(View.INVISIBLE);
            pl2dice.setVisibility(View.INVISIBLE);
            pl1name.setText("PLAYER 1\nWINNER!!");
            pl1name.setTextColor(Color.rgb(255,51,61));
            pl1back.setBackgroundColor(Color.WHITE);
            pl2back.setBackgroundColor(Color.WHITE);
        }
        else if (score2 >= 100){
            pl1dot.setVisibility(View.INVISIBLE);
            pl2dot.setVisibility(View.INVISIBLE);
            pl1hold.setVisibility(View.INVISIBLE);
            pl2hold.setVisibility(View.INVISIBLE);
            pl1roll.setVisibility(View.INVISIBLE);
            pl2roll.setVisibility(View.INVISIBLE);
            pl1dice.setVisibility(View.INVISIBLE);
            pl2dice.setVisibility(View.INVISIBLE);
            pl2name.setText("PLAYER 2\nWINNER!!");
            pl2name.setTextColor(Color.rgb(255,51,61));
            pl1back.setBackgroundColor(Color.WHITE);
            pl2back.setBackgroundColor(Color.WHITE);
        }
    }

    public void newgame(View view) {

        current1 = 0;
        pl1current.setText("0");

        score1 = 0;
        pl1score.setText("0");

        score2 = 0 ;
        pl2score.setText("0");

        current2 = 0;
        pl2current.setText("0");

        pl1name.setText("PLAYER 1 ");
        pl2name.setText("PLAYER 2 ");

        pl2name.setTextColor(Color.rgb(113,113,113));

        pl1name.setTextColor(Color.rgb(113,113,113));

        pl1dice.setVisibility(View.VISIBLE);

        pl2dice.setVisibility(View.VISIBLE);

        pl1dice.setImageResource(R.drawable.dice1);

        pl2dice.setImageResource(R.drawable.dice1);

        player1 = true;
        pl1dot.setVisibility(View.VISIBLE);
        pl2dot.setVisibility(View.INVISIBLE);
        pl1back.setBackgroundColor(Color.rgb(240,240,240));
        pl2back.setBackgroundColor(Color.rgb(255,255,255));
        pl2hold.setVisibility(View.INVISIBLE);
        pl1hold.setVisibility(View.VISIBLE);
        pl1roll.setVisibility(View.VISIBLE);
        pl2roll.setVisibility(View.INVISIBLE);

    }
}