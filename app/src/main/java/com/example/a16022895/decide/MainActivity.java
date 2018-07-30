package com.example.a16022895.decide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btStartBottleSpin = findViewById(R.id.btStartBottleSpin);
        Button btnStartCoinFlip = findViewById(R.id.btStartCoinFlip);
        Button btnStartMagicBall = findViewById(R.id.btStartMagicBall);


        btStartBottleSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartBottleSpin();
            }
        });

        btnStartCoinFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCoinFlip();
            }
        });

        btnStartMagicBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMagicBall();
            }
        });
    }

    private void StartBottleSpin() {
        Intent intent = new Intent(this, bottleSpinActivity.class);
        startActivity(intent);
    }

    private void startCoinFlip(){
        Intent intent = new Intent(this,coinFlipActivity.class);
        startActivity(intent);
    }

    private void startMagicBall(){
        Intent intent = new Intent(this,magicBallActivity.class);
        startActivity(intent);
    }
}
