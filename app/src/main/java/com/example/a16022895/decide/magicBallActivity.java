package com.example.a16022895.decide;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class magicBallActivity extends AppCompatActivity {

    private ImageView ballIV;
    private TextView answer;

    private String[] answersArray = {"It is certain", "It is decidedly so", "Without a doubt", "Yes definitely", "You may rely on it", "As I see it, yes",
        "Most likely", "Outlook good", "Yes", "Signs point to yes", "Reply hazy try again", "Ask again later",
        "Better not tell you now", "Cannot predict now", "Concentrate and ask again", "Don't count on it",
        "My reply is no", "My sources say no", "Outlook not so good", "Very doubtful"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_ball);

        ballIV = (ImageView)findViewById(R.id.magicBall);
        answer = (TextView)findViewById(R.id.answer);

        ballIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.magicBall:

                        int rand = new Random().nextInt(answersArray.length);
                        answer.setText(answersArray[rand]);

                        break;
                }

                RotateAnimation rotate = new RotateAnimation(0, 360,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(1000);
                ballIV.startAnimation(rotate);
            }
        });
    }
}
