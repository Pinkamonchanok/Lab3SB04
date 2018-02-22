package com.example.pinkamon.myapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private TextSwitcher textSw;
    private int mCounter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSw = findViewById(R.id.switcher);
        textSw.setFactory(mFactory);
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        textSw.setInAnimation(in);
        textSw.setOutAnimation(out);



        Button increaseButton = findViewById(R.id.btn_inc);
        Button decreaseButton = findViewById(R.id.btn_dec);
        Button clearButton = findViewById(R.id.btn_clr);


        increaseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCounter++;
                // BEGIN_INCLUDE(settext)
                textSw.setText(String.valueOf(mCounter));
                // END_INCLUDE(settext)
            }
        });
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter--;
                // BEGIN_INCLUDE(settext)
                textSw.setText(String.valueOf(mCounter));
                // END_INCLUDE(settext)
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter = 0;
                // BEGIN_INCLUDE(settext)
                textSw.setText(String.valueOf(mCounter));
                // END_INCLUDE(settext)
            }
        });

    }

    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(MainActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };



}
