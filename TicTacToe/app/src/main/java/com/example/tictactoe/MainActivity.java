package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TAG = "TicTacToe";

    //Making a new function for handling cases


    void function( int n )
    {
        System.out.println("n" + " Copy of n instances");
    }

    //Make sure to make text view's initially invisible and inorder to make them reappar at the time of relaunch

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: onCreate Method has been executed.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //New learning what is tag mean go and search for tag in xml

    //Designing the game logic behind this

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    int countMoves = 0;
    int activePlayer = 0;




    //Making active comment above all the laws and role of time and close to zero and this closeness makes all of the following in the park.


    boolean activeGame = true;

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());


        if (gameState[tappedCounter] == 2 && activeGame) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);
                countMoves++;
                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.red);
                countMoves++;
                activePlayer = 0;

            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            //Winning Logic for games :


            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {

                    // Somone has won!

                    activeGame = false;

                    String winner = "";

                    if (activePlayer == 1) {

                        winner = "Yellow";

                    } else {

                        winner = "Red";

                    }

                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

                    winnerTextView.setText(winner + " has won!");

                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerTextView.setVisibility(View.VISIBLE);

                }

            }

        }

        nobody(countMoves,activeGame);

    }

    public void nobody(int countMoves, boolean activeGame)
    {
        if(countMoves == 9 && activeGame) {
            Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

            TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

            winnerTextView.setText("Nobody won! Dumb Fools");

            playAgainButton.setVisibility(View.VISIBLE);

            winnerTextView.setVisibility(View.VISIBLE);

        }
    }

    //Making game for next play : Play Again

    public void playAgain(View view) {

        countMoves = 0;


        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

        playAgainButton.setVisibility(View.INVISIBLE);

        winnerTextView.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }

        for (int i = 0; i < gameState.length; i++) {

            gameState[i] = 2;

        }

        activePlayer = 0;

        activeGame = true;

    }

    //Making logic for tic-tac-toe and getting familiar with the software

}