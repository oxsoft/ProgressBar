package com.sample.progressbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate");

        final Button openSecond = (Button) findViewById(R.id.open_second);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        final Button toggleProgressBar = (Button) findViewById(R.id.toggle_progress_bar);

        openSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        toggleProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progressBar.getVisibility() == View.VISIBLE) {
                    toggleProgressBar.setText(R.string.show_progress_bar);
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    toggleProgressBar.setText(R.string.hide_progress_bar);
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        TextView rotatingView = (TextView) findViewById(R.id.rotating_text);
        {
            RotateAnimation loadAnimation =
                    (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.rotate_repeat);
            rotatingView.startAnimation(loadAnimation);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
        Toast.makeText(this, TAG + " onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "onStop");
        Toast.makeText(this, TAG + " onStop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }
}
