package com.example.touchsomegrass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import presenters.TimerContract;
import presenters.TimerPresenter;

public class Configuration extends AppCompatActivity implements TimerContract.TimerView {
    private TimerContract.TimerPresenter timerPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.timerPresenter = new TimerPresenter();
        this.timerPresenter.setView(this);
        setContentView(R.layout.activity_configuration);
        TextInputLayout layoutName = findViewById(R.id.configuration_name);
        EditText inputName = findViewById(R.id.input_name);
        EditText inputMessage = findViewById(R.id.input_message);
        EditText inputInterval = findViewById(R.id.input_interval);
        EditText inputTimeToActive = findViewById(R.id.input_break);
        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                Log.i("Configuration", "" + s);
                timerPresenter.setName(s.toString());
            }
        });
        inputMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                timerPresenter.setMessage(s.toString());
            }
        });
        inputInterval.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                timerPresenter.setInterval(s.toString());
            }
        });
        inputTimeToActive.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                timerPresenter.setMessage(s.toString());
            }
        });
    }

    @Override
    public void showError(String error) {
    }

    @Override
    public void showSucesss() throws Exception {
    }

    public void saveConfigs(android.view.View view) {
        if (this.timerPresenter.verifyFields()) {
            //TODO: startAcitvy
        }
    }
}