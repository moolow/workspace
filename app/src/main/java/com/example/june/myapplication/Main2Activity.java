package com.example.june.myapplication;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout;
    private View mCardBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mCardFrontLayout = findViewById(R.id.front);
        mCardBackLayout = findViewById(R.id.back);
        View frame = findViewById(R.id.card);
        mSetRightOut = (AnimatorSet)AnimatorInflater.loadAnimator(this,
                R.animator.out_animation);
        mSetLeftIn = (AnimatorSet)AnimatorInflater.loadAnimator(this,
                R.animator.in_animation);
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mCardFrontLayout.setCameraDistance(scale);
        mCardBackLayout.setCameraDistance(scale);

        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSetLeftIn.isRunning() || mSetRightOut.isRunning()) {
                    // nothing
                } else {
                    flipCard(v);
                }
            }
        });


    }
    public void flipCard(View view) {
        if (!mIsBackVisible) {
            mSetRightOut.setTarget(mCardFrontLayout);
            mSetLeftIn.setTarget(mCardBackLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;
        } else {
            mSetRightOut.setTarget(mCardBackLayout);
            mSetLeftIn.setTarget(mCardFrontLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
        }
    }
}
