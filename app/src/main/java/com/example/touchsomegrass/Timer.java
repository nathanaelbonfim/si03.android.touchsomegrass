package com.example.touchsomegrass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import presenters.ConfigurationContract;
import presenters.ConfigurationPresenter;
import presenters.ContractTimer;
import presenters.TimerPresenter;

public class Timer extends AppCompatActivity implements ContractTimer.TimerView {
    private ContractTimer.TimerPresenter timerPresenter = new TimerPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

    }


    @Override
    public void changeState() {

    }
}