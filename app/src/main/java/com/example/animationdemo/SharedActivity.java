package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SharedActivity extends AppCompatActivity {
    private ImageView img;
    private Button Btn_continue,Btn_cancel;
    Animation fade,fade2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        img=findViewById(R.id.shared_image);
        Btn_continue=findViewById(R.id.btn_continue);
        Btn_cancel=findViewById(R.id.btn_cancel);
        fade= AnimationUtils.loadAnimation(this,R.anim.fade);
        fade2= AnimationUtils.loadAnimation(this,R.anim.fade2);

        Btn_continue.setAlpha(0);
        Btn_cancel.setAlpha(0);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Btn_cancel.setAlpha(1);
                Btn_continue.setAlpha(1);
                Btn_continue.startAnimation(fade);
                Btn_cancel.startAnimation(fade2);
                img.setClickable(false);
            }
        });
        Btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Btn_continue.setAlpha(0);
                Btn_cancel.setAlpha(0);
                img.setClickable(true);
            }
        });

    }
}