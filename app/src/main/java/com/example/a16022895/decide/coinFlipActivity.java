package com.example.a16022895.decide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class coinFlipActivity extends AppCompatActivity implements Animation.AnimationListener{

    public static final Random RANDOM = new Random();
    private ImageView coin;
    private Button btn;
    Animation fromMiddle,toMiddle;
    Boolean isStop=true,isBackShow=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip);

        coin = findViewById(R.id.ivCoin);
        btn = findViewById(R.id.button);

        fromMiddle = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.from_middle);
        toMiddle = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.to_middle);

        toMiddle.setRepeatCount(1);
        fromMiddle.setRepeatCount(1);

        toMiddle.setAnimationListener(this);
        fromMiddle.setAnimationListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isStop){
                    coin.clearAnimation();
                    coin.setAnimation(toMiddle);
                    coin.startAnimation(toMiddle);

                    btn.setText("STOP");
                }else{
                    int number = new Random().nextInt(100)+1;
                    if(number % 2 == 0)
                        coin.setImageResource(R.drawable.heads);
                    else
                        coin.setImageResource(R.drawable.tails);

                    coin.clearAnimation();
                    btn.setText("FLIP");
                }

                isStop = !isStop;
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

        if(animation == toMiddle){
            coin.clearAnimation();
            coin.setAnimation(fromMiddle);
            coin.startAnimation(fromMiddle);

            if(isBackShow)
                coin.setImageResource(R.drawable.tails);
            else
                coin.setImageResource(R.drawable.heads);
            isBackShow = !isBackShow;
        }else{
            coin.clearAnimation();
            coin.setAnimation(toMiddle);
            coin.startAnimation(toMiddle);

            if(isBackShow)
                coin.setImageResource(R.drawable.tails);
            else
                coin.setImageResource(R.drawable.heads);
            isBackShow = !isBackShow;
        }
    }
}
