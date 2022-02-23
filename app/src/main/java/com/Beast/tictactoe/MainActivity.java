package com.Beast.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //State Meanings
    // 0 - X
    // 1 - O
    // 2 - NULL
    boolean gameActive = false;
    int activePlayer = 0;
    int[] gameState = { 2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPos = {
            {0,1,2},{3,4,5},{6,7,8},        //rows
            {0,3,6},{1,4,7},{2,5,8},        //columns
            {0,4,8},{2,4,6}                 //diagonal
    };
    public void playerTap(View view)
    {
        ImageView img = (ImageView) view;
        TextView status = findViewById(R.id.textStatus);
        int tappedImg = Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            gameReset(view);
        }
        if(gameState[tappedImg] == 2 && gameActive)
        {
            gameState[tappedImg]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                status.setText(" O's Turn - Tap To Play ");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                status.setText(" X's Turn - Tap To Play ");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //check which player has won
        for(int[] list : winPos)
        {
            if ((gameState[list[0]] == gameState[list[1]]) && (gameState[list[1]] == gameState[list[2]]) && gameState[list[0]] != 2)
            {
                int winner = list[0];
                if(winner==1) {
                    status.setText("🎉Hurray!! 'O' is the Winner🎉");

                }
                else {
                    status.setText("🎉Hurray!! 'X' is the Winner🎉");
                }
            }
        }

    }

    public void gameReset(View view) {
        if(gameActive)
            Toast.makeText(this, "Game has been reset!!", Toast.LENGTH_SHORT).show();
        gameActive = true;
        activePlayer = 0;
        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Made By 🔰ComradeXBeast🔰", Toast.LENGTH_LONG).show();
    }
}