package com.example.touchsomegrass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import presenters.ConfigurationContract;
import presenters.ConfigurationPresenter;

public class Timer extends AppCompatActivity implements ConfigurationContract.ConfigurationView {
    private ConfigurationContract.ConfigurationPresenter configurationPresenter = new ConfigurationPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        configurationPresenter.setView(this);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showSucesss() throws Exception {

    }
}