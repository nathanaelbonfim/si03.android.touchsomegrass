package com.example.touchsomegrass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import presenters.ConfigurationContract;
import presenters.ConfigurationPresenter;

public class Configuration extends BaseActivity implements ConfigurationContract.ConfigurationView {
    private ConfigurationContract.ConfigurationPresenter configurationPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.configurationPresenter = new ConfigurationPresenter();
        this.configurationPresenter.setView(this);
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
                configurationPresenter.setName(s.toString());
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
                configurationPresenter.setMessage(s.toString());
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
                configurationPresenter.setInterval(s.toString());
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
                configurationPresenter.setMessage(s.toString());
            }
        });
    }

    @Override
    public void showError(String error) {
    }

    @Override
    public void showSucesss() throws Exception {
    }

    public void saveConfigs(View view) {
        Intent intent = new Intent(this, Timer.class);
        startActivity(intent);
//        if (this.configurationPresenter.verifyFields()) {
//        }
    }
}