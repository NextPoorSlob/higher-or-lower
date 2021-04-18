package com.nextpoorslob.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int LOWER_BOUNDARY = 1;
    private static final int UPPER_BOUNDARY = 20;

    private int numberThoughtOf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thinkOfNewNumber();
    }

    public void makeGuess(View view) {

        EditText editTextGuess = findViewById(R.id.editTextGuess);
        String guessAsString = editTextGuess.getText().toString();
        Log.i("HigherOrLower", "Guess made: " + guessAsString);

        int guess = Integer.parseInt(guessAsString);

        if (guess < LOWER_BOUNDARY) {
            Toast.makeText(this, "Guess must be greater than or equal to " + LOWER_BOUNDARY,
                    Toast.LENGTH_LONG).show();
            return;
        }

        if (guess > UPPER_BOUNDARY) {
            Toast.makeText(this, "Guess must be less than or equal to " + UPPER_BOUNDARY,
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (guess < numberThoughtOf) {
            Toast.makeText(this, "Too low!", Toast.LENGTH_LONG).show();
        } else if (guess > numberThoughtOf) {
            Toast.makeText(this, "Too high!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "BOO-YAH! You guessed it!", Toast.LENGTH_LONG).show();
            thinkOfNewNumber();
        }

    }

    private void thinkOfNewNumber() {
        numberThoughtOf = new Random().nextInt((UPPER_BOUNDARY - LOWER_BOUNDARY) + 1) + LOWER_BOUNDARY;
        Log.i("HigherOrLower", "Number thought of is " + numberThoughtOf);
    }
}