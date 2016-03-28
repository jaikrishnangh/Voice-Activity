package com.example.jaikrishnan.voiceactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by JAI KRISHNAN on 10-02-2016.
 */
public class Home extends Activity{

    ImageView a,b,c,d;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        a = (ImageView) findViewById(R.id.a);
        b = (ImageView) findViewById(R.id.b);
        c = (ImageView) findViewById(R.id.c);
        d = (ImageView) findViewById(R.id.d);

        animation = AnimationUtils.loadAnimation(Home.this,R.anim.bottom_in);
        animation.setDuration(1500);
        a.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(Home.this,R.anim.right_in);
        animation.setDuration(1500);
        b.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(Home.this,R.anim.slide_in_top);
        animation.setDuration(1500);
        c.setAnimation(animation);


        animation = AnimationUtils.loadAnimation(Home.this,R.anim.slide_left_in);
        animation.setDuration(1500);
        d.setAnimation(animation);

    }
}
