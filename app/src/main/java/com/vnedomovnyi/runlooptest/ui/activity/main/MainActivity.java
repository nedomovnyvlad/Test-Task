package com.vnedomovnyi.runlooptest.ui.activity.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.vnedomovnyi.runlooptest.R;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}