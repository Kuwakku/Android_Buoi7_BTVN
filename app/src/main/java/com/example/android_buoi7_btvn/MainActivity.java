package com.example.android_buoi7_btvn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ILoadSumListener{
    private ProgressBar progressBar;
    private TextView tvResult;
    private LinearLayout llLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.pbLoading);
        tvResult = findViewById(R.id.tvResult);
        llLoading = findViewById(R.id.llLoading);

        LoadSumAsyncTask loadSumAsyncTask = new LoadSumAsyncTask(progressBar, tvResult);
        loadSumAsyncTask.setILoadSumListener(this);
        llLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadSumSuccess(Long aLong) {
        llLoading.setVisibility(View.GONE);
    }

    @Override
    public void onLoadSumError(String message) {
        llLoading.setVisibility(View.GONE);
    }
}